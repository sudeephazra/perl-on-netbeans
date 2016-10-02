// Generated from Perl.g4 by ANTLR 4.5
package org.language.perl.grammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PerlParser}.
 */
public interface PerlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PerlParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(PerlParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerlParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(PerlParser.ProgContext ctx);
}