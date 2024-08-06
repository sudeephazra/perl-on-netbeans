package org.language.perl.project;

import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;

public class PerlProjectFilterNodeFactory extends FilterNode.Children{
    
        public PerlProjectFilterNodeFactory(Node node) {
        super(node);
    }
    
    @Override
    protected Node[] createNodes(Node key) {
        if (key.getName().startsWith("nbproject") || key.getName().equals(".git") ) {
            return new Node[]{};
        }
        return new Node[] {copyNode(key)};
        
    }
}
