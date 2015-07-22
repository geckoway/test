package com.test.lu.t1;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;

public class FSDirectoryTest {

	// 建立索引的路径
	public static final String path = "H:\\index2";

	public static void main(String[] args) throws Exception {
		Document doc1 = new Document();
		doc1.add(new Field("name", "lighter javaeye com ", Field.Store.YES, Field.Index.TOKENIZED));

		Document doc2 = new Document();
		doc2.add(new Field("name", " lighter blog ", Field.Store.YES, Field.Index.TOKENIZED));

		IndexWriter writer = new IndexWriter(FSDirectory.getDirectory(path), new StandardAnalyzer(), true);
		writer.setMaxFieldLength(3);
		writer.addDocument(doc1);
		writer.setMaxFieldLength(3);
		writer.addDocument(doc2);
		writer.close();

		IndexSearcher searcher = new IndexSearcher(path);
		Hits hits = null;
		Query query = null;
		QueryParser qp = new QueryParser("name", new StandardAnalyzer());
		query = qp.parse("lighter");
		hits = searcher.search(query);
		System.out.println("查找\"lighter\"  共 " + hits.length() + " 个结果 ");
		for (int i = 0; i < hits.length(); i++) {
			Document dc = hits.doc(i);
			System.out.println(dc.get("name"));
		}

		query = qp.parse("javaeye");
		hits = searcher.search(query);
		System.out.println("查找\"javaeye\"  共 " + hits.length() + " 个结果 ");

	}

	public void UniteIndex() throws Exception {
		IndexWriter writerDisk = new IndexWriter(FSDirectory.getDirectory("H:\\indexDisk"), new StandardAnalyzer(),
				true);
		Document docDisk = new Document();
		docDisk.add(new Field("name", "程序员之家 ", Field.Store.YES, Field.Index.TOKENIZED));
		writerDisk.addDocument(docDisk);
		RAMDirectory ramDir = new RAMDirectory();
		IndexWriter writerRam = new IndexWriter(ramDir, new StandardAnalyzer(), true);
		Document docRam = new Document();
		docRam.add(new Field("name", "程序员杂志 ", Field.Store.YES, Field.Index.TOKENIZED));
		writerRam.addDocument(docRam);
		writerRam.close();// 这个方法非常重要，是必须调用的
		writerDisk.addIndexes(new Directory[] { ramDir });
		writerDisk.close();
	}

	public void UniteSearch() throws Exception {
		QueryParser queryParser = new QueryParser("name", new StandardAnalyzer());
		Query query = queryParser.parse("程序员");
		IndexSearcher indexSearcher = new IndexSearcher("H:\\indexDisk ");
		Hits hits = indexSearcher.search(query);
		System.out.println(" 找到了 " + hits.length() + " 结果 ");
		for (int i = 0; i < hits.length(); i++) {
			Document doc = hits.doc(i);
			System.out.println(doc.get(" name "));
		}
	}
}