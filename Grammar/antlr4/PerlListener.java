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
	/**
	 * Enter a parse tree produced by {@link PerlParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(PerlParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerlParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(PerlParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PerlParser#import_statements}.
	 * @param ctx the parse tree
	 */
	void enterImport_statements(PerlParser.Import_statementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerlParser#import_statements}.
	 * @param ctx the parse tree
	 */
	void exitImport_statements(PerlParser.Import_statementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PerlParser#import_statement}.
	 * @param ctx the parse tree
	 */
	void enterImport_statement(PerlParser.Import_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerlParser#import_statement}.
	 * @param ctx the parse tree
	 */
	void exitImport_statement(PerlParser.Import_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PerlParser#package_declaration}.
	 * @param ctx the parse tree
	 */
	void enterPackage_declaration(PerlParser.Package_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerlParser#package_declaration}.
	 * @param ctx the parse tree
	 */
	void exitPackage_declaration(PerlParser.Package_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PerlParser#print_statement}.
	 * @param ctx the parse tree
	 */
	void enterPrint_statement(PerlParser.Print_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerlParser#print_statement}.
	 * @param ctx the parse tree
	 */
	void exitPrint_statement(PerlParser.Print_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PerlParser#use_statement}.
	 * @param ctx the parse tree
	 */
	void enterUse_statement(PerlParser.Use_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerlParser#use_statement}.
	 * @param ctx the parse tree
	 */
	void exitUse_statement(PerlParser.Use_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PerlParser#require_statement}.
	 * @param ctx the parse tree
	 */
	void enterRequire_statement(PerlParser.Require_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerlParser#require_statement}.
	 * @param ctx the parse tree
	 */
	void exitRequire_statement(PerlParser.Require_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PerlParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVariable_declaration(PerlParser.Variable_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerlParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVariable_declaration(PerlParser.Variable_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PerlParser#comment_statements}.
	 * @param ctx the parse tree
	 */
	void enterComment_statements(PerlParser.Comment_statementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerlParser#comment_statements}.
	 * @param ctx the parse tree
	 */
	void exitComment_statements(PerlParser.Comment_statementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PerlParser#comment_statement}.
	 * @param ctx the parse tree
	 */
	void enterComment_statement(PerlParser.Comment_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PerlParser#comment_statement}.
	 * @param ctx the parse tree
	 */
	void exitComment_statement(PerlParser.Comment_statementContext ctx);
}