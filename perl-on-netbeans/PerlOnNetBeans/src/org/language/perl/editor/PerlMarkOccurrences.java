/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.language.perl.editor;

import java.awt.Color;
import java.lang.ref.WeakReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JEditorPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyleConstants;
import org.netbeans.api.editor.settings.AttributesUtilities ;
import org.netbeans.modules.editor.NbEditorUtilities ;
import org.netbeans.spi.editor.highlighting.support.OffsetsBag ;
import org.openide.cookies.EditorCookie ;
import org.openide.loaders.DataObject ;
import org.openide.util.RequestProcessor ;
/**
 *
 * @author Sudeep
 */
public class PerlMarkOccurrences implements CaretListener {
     private static final AttributeSet defaultColors =
            AttributesUtilities.createImmutable(StyleConstants.Background,
            new Color(236, 235, 163));
    
    private final OffsetsBag bag;
    
    private JTextComponent comp;
    private final WeakReference<Document> weakDoc;
    
    private final RequestProcessor rp;
    private final static int REFRESH_DELAY = 100;
    private RequestProcessor.Task lastRefreshTask;

    public PerlMarkOccurrences(Document doc) {
        rp = new RequestProcessor(PerlMarkOccurrences.class);
        bag = new OffsetsBag(doc);
        weakDoc = new WeakReference<Document>(doc);
        DataObject dobj = NbEditorUtilities.getDataObject(weakDoc.get());
        if (dobj != null) {
            EditorCookie pane = dobj.getLookup().lookup(EditorCookie.class);
            JEditorPane[] panes = pane.getOpenedPanes();
            if (panes != null && panes.length > 0) {
                comp = panes[0];
                comp.addCaretListener(this);
            }
        }
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        bag.clear();
        setupAutoRefresh();
    }

    public void setupAutoRefresh() {
        if (lastRefreshTask == null) {
            lastRefreshTask = rp.create(new Runnable() {
                @Override
                public void run() {
                    String selection = comp.getSelectedText();
                    if (selection != null) {
                        try {
                        Pattern p = Pattern.compile(selection);
                        //Matcher m = p.matcher(comp.getText().replaceAll("(\\n)", ""));
                        Matcher m = 
                                p.matcher(comp.getText().replaceAll(System.getProperty("line.separator"), " "));
                        while (m.find() == true) {
                            int startOffset = m.start();
                            int endOffset = m.end();
                            bag.addHighlight(startOffset, endOffset, defaultColors);
                        }
                        } catch (Exception e) {
                            Logger.getLogger(PerlMarkOccurrences.class.getName()).log(Level.WARNING, "Perl Mark occurences issue");
                        }
                    }
                }
            });
        }

        lastRefreshTask.schedule(REFRESH_DELAY);
    }

    public OffsetsBag getHighlightsBag() {
        return bag;
    }
}
