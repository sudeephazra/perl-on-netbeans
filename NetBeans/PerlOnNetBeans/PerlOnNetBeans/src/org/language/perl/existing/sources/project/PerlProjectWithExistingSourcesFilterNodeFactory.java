/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.existing.sources.project;

import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;


public class PerlProjectWithExistingSourcesFilterNodeFactory extends FilterNode.Children {
    
    public PerlProjectWithExistingSourcesFilterNodeFactory(Node node) {
        super(node);
    }
    
    @Override
    protected Node[] createNodes(Node key) {
        if (key.getName().startsWith("nbproject")) {
            return new Node[]{};
        }
        return new Node[] {copyNode(key)};
        
    }
    
    
}
