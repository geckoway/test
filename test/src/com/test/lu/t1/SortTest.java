package com.test.lu.t1;

import java.io.IOException;

import org.apache.lucene.analysis.standard.ParseException;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.RangeQuery;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.junit.Test;

public class SortTest {
	
	public void IndexSort() throws IOException {
		IndexWriter writer = new IndexWriter("H:\\lucene\\indexStore ", new StandardAnalyzer(), true);
		Document doc = new Document();
		doc.add(new Field("sort", "1", Field.Store.YES, Field.Index.TOKENIZED));
		writer.addDocument(doc);
		doc = new Document();
		doc.add(new Field("sort", "4", Field.Store.YES, Field.Index.TOKENIZED));
		writer.addDocument(doc);
		doc = new Document();
		doc.add(new Field("sort", "3", Field.Store.YES, Field.Index.TOKENIZED));
		writer.addDocument(doc);
		doc = new Document();
		doc.add(new Field("sort", "5", Field.Store.YES, Field.Index.TOKENIZED));
		writer.addDocument(doc);
		doc = new Document();
		doc.add(new Field("sort", "9", Field.Store.YES, Field.Index.TOKENIZED));
		writer.addDocument(doc);
		doc = new Document();
		doc.add(new Field("sort", "6", Field.Store.YES, Field.Index.TOKENIZED));
		writer.addDocument(doc);
		doc = new Document();
		doc.add(new Field("sort", "7", Field.Store.YES, Field.Index.TOKENIZED));
		writer.addDocument(doc);
		writer.close();
	}

	public void SearchSort1() throws Exception {
		IndexSearcher indexSearcher = new IndexSearcher("H:\\lucene\\indexStore");
		QueryParser queryParser = new QueryParser("sort", new StandardAnalyzer());
		Query query = queryParser.parse("4");

		Hits hits = indexSearcher.search(query);
		System.out.println("有" + hits.length() + "个结果");
		Document doc = hits.doc(0);
		System.out.println(doc.get("sort"));
	}

	@Test
	public void SearchSort2() throws IOException, ParseException {
		IndexSearcher indexSearcher = new IndexSearcher("H:\\lucene\\indexStore");
		Query query = new RangeQuery(new Term("sort", "1"), new Term("sort", "5"), true);// 这个地方前面没有提到，它是用于范围的Query可以看一下帮助文档.
		Hits hits = indexSearcher.search(query, new Sort(new SortField("sort", new MySortComparatorSource())));
		System.out.println("有" + hits.length() + "个结果");
		for (int i = 0; i < hits.length(); i++) {
			Document doc = hits.doc(i);
			System.out.println(doc.get("sort"));
		}
	}
}
