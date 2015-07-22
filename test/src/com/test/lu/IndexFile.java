package com.test.lu;


public class IndexFile {
//	protected String[] ids = { "1", "2" };
//
//	protected String[] content = { "Amsterdam has lost of fff  cancals", "i love  fff this girl" };
//
//	protected String[] city = { "Amsterdam", "Venice" };
//
//	private Directory dir;
//
//	/**
//	 * 初始添加文档
//	 * 
//	 * @throws Exception
//	 */
//	@Test
//	public void init() throws Exception {
//		String pathFile = "H://lucene/index";
//		dir = FSDirectory.open(new File(pathFile));
//		IndexWriter writer = getWriter();
//		for (int i = 0; i < ids.length; i++) {
//			Document doc = new Document();
//			doc.add(new StringField("id", ids[i], Store.YES));
//			doc.add(new TextField("content", content[i], Store.YES));
//			doc.add(new StringField("city", city[i], Store.YES));
//			writer.addDocument(doc);
//		}
//		System.out.println("init ok?");
//		writer.close();
//	}
//
//	/**
//	 * 获得IndexWriter对象
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	public IndexWriter getWriter() throws Exception {
//		Analyzer analyzer = new StandardAnalyzer();
//		IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_40, analyzer);
//		return new IndexWriter(dir, iwc);
//	}
}
