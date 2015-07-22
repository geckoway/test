package com.test.lu;


public class IndexSearch {
	/**
	 * 查询
	 * 
	 * @throws Exception
	 */
//	@Test
//	public void search() throws Exception {
//		String filePath = "H://lucene/index";
//		Directory dir = FSDirectory.open(new File(filePath));
//		IndexReader reader = DirectoryReader.open(dir);
//		IndexSearcher searcher = new IndexSearcher(reader);
//		Term term = new Term("city", "add");
//		TermQuery query = new TermQuery(term);
//		TopDocs topdocs = searcher.search(query, 5);
//		ScoreDoc[] scoreDocs = topdocs.scoreDocs;
//		System.out.println("查询结果总数---" + topdocs.totalHits + "最大的评分--" + topdocs.getMaxScore());
//		for (int i = 0; i < scoreDocs.length; i++) {
//			int doc = scoreDocs[i].doc;
//			Document document = searcher.doc(doc);
//			System.out.println("content====" + document.get("city"));
//			System.out.println("id--" + scoreDocs[i].doc + "---scors--" + scoreDocs[i].score + "---index--"
//					+ scoreDocs[i].shardIndex);
//		}
//		reader.close();
//	}
}
