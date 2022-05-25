/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.project.existing.sources;

import java.awt.Component;
import java.util.HashSet;
import java.util.Set;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.openide.WizardDescriptor;
import org.openide.WizardValidationException;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;

/**
 * Panel just asking for basic info.
 */
public class PerlProjectWithExistingSourcesWizardPanel implements WizardDescriptor.Panel<WizardDescriptor>,
        WizardDescriptor.ValidatingPanel<WizardDescriptor>, WizardDescriptor.FinishablePanel<WizardDescriptor> {

    private WizardDescriptor wizardDescriptor;
    private PerlProjectWithExistingSourcesPanelVisual component;

    public PerlProjectWithExistingSourcesWizardPanel() {
    }

    @Override
    public Component getComponent() {
        if (component == null) {
            component = new PerlProjectWithExistingSourcesPanelVisual(this);
            component.setName(NbBundle.getMessage(PerlProjectWithExistingSourcesWizardPanel.class, "LBL_CreateProjectStep"));
        }
        return component;
    }

    @Override
    public HelpCtx getHelp() {
        return new HelpCtx(PerlProjectWithExistingSourcesWizardPanel.class.getName().trim());
    }

    @Override
    public boolean isValid() {
        getComponent();
        return component.valid(wizardDescriptor);
    }

    private final Set<ChangeListener> listeners = new HashSet<>(1); // or can use ChangeSupport in NB 6.0

    @Override
    public final void addChangeListener(ChangeListener l) {
        synchronized (listeners) {
            listeners.add(l);
        }
    }

    @Override
    public final void removeChangeListener(ChangeListener l) {
        synchronized (listeners) {
            listeners.remove(l);
        }
    }

    protected final void fireChangeEvent() {
        Set<ChangeListener> ls;
        synchronized (listeners) {
            ls = new HashSet<>(listeners);
        }
        ChangeEvent ev = new ChangeEvent(this);
        for (ChangeListener l : ls) {
            l.stateChanged(ev);
        }
    }

    @Override
    public boolean isFinishPanel() {
        return true;
    }

    @Override
    public void validate() throws WizardValidationException {
        getComponent();
        component.validate(wizardDescriptor);
    }

    @Override
    public void readSettings(WizardDescriptor data) {
        wizardDescriptor = data;
        component.read(wizardDescriptor);
    }

    @Override
    public void storeSettings(WizardDescriptor data) {
        WizardDescriptor d = data;
        component.store(d);
    }

}
