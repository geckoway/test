package com.test.lu;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;

public class TestQuery {
	public static void main(String[] args) throws Exception, ParseException {
		Hits hits = null;
		String queryString = "中华 ";
		Query query = null;
		IndexSearcher searcher = new IndexSearcher("H:\\index ");

		Analyzer analyzer = new StandardAnalyzer();
		QueryParser qp = new QueryParser("body", analyzer);
		query = qp.parse(queryString);
		if (searcher != null) {
			hits = searcher.search(query);
			System.out.println(hits.doc(0).getFields().get(0).toString());
			if (hits.length() > 0) {
				System.out.println(" 找到: " + hits.length() + "  个结果! ");
			}
		}
	}

}
