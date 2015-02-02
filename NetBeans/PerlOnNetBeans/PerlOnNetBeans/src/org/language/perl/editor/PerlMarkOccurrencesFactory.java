/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.language.perl.editor;

import javax.swing.text.Document;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.api.editor.mimelookup.MimeRegistrations;
import org.netbeans.spi.editor.highlighting.HighlightsLayer ;
import org.netbeans.spi.editor.highlighting.HighlightsLayerFactory ;
import org.netbeans.spi.editor.highlighting.ZOrder ;

@MimeRegistrations({
    @MimeRegistration(mimeType = "text/x-perl", service = HighlightsLayerFactory.class)
})
public class PerlMarkOccurrencesFactory implements HighlightsLayerFactory  {

    public static PerlMarkOccurrences getMarkOccurrencesHighlighter(Document doc) {
        PerlMarkOccurrences highlighter =
               (PerlMarkOccurrences) doc.getProperty(PerlMarkOccurrences.class);
        if (highlighter == null) {
            doc.putProperty(PerlMarkOccurrences.class,
               highlighter = new PerlMarkOccurrences(doc));
        }
        return highlighter;
    }

    @Override
    public HighlightsLayer[] createLayers (Context  context) {
        return new HighlightsLayer[]{
                    HighlightsLayer.create (
                    PerlMarkOccurrences.class.getName(),
                    ZOrder.CARET_RACK.forPosition(2000) ,
                    true,
                    getMarkOccurrencesHighlighter(context.getDocument()).getHighlightsBag() )
                };
    }

}