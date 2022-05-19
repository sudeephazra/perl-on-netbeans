
package org.language.perl.parser;

import java.util.Collection;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.ParserFactory;



public class PerlParserFactory extends ParserFactory{
    
    @Override
    public Parser createParser(Collection<Snapshot> clctn) {
        return new Perl5Parser();
    }
}
