package com.test.lu.t1;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.ScoreDocComparator;
import org.apache.lucene.search.SortField;

public class MyScoreDocComparator implements ScoreDocComparator {
	private Integer[] sort;

	public MyScoreDocComparator(String s, IndexReader reader, String fieldname) throws IOException {
		sort = new Integer[reader.maxDoc()];
		for (int i = 0; i < reader.maxDoc(); i++) {
			Document doc = reader.document(i);
			sort[i] = new Integer(doc.get("sort"));
		}
	}

	public int compare(ScoreDoc i, ScoreDoc j) {
		if (sort[i.doc] > sort[j.doc])
			return 1;
		if (sort[i.doc] < sort[j.doc])
			return -1;
		return 0;
	}

	public int sortType() {
		return SortField.INT;
	}

	public Comparable sortValue(ScoreDoc i) {
		// TODO 自动生成方法存根
		return new Integer(sort[i.doc]);
	}
}