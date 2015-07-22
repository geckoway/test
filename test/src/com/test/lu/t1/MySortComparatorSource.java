package com.test.lu.t1;

import java.io.IOException;

import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.ScoreDocComparator;
import org.apache.lucene.search.SortComparatorSource;

public class MySortComparatorSource implements SortComparatorSource {
	private static final long serialVersionUID = -9189690812107968361L;

	public ScoreDocComparator newComparator(IndexReader reader, String fieldname) throws IOException {
		if (fieldname.equals("sort"))
			return new MyScoreDocComparator("sort", reader, fieldname);
		return null;
	}
}