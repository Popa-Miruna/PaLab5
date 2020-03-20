import java.io.InvalidObjectException;

public class Main {

    public static void main(String[] args) {
        testCreateSave();
        testLoadView();
    }

    public static void testCreateSave() {
        Catalog catalog = new Catalog( "CATALOG1", "C:/Users/User/IdeaProjects/Laborator5[PA]/catalog.ser" );
        Document doc = new Document( "java1", "Java Course 1", "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf" );
        doc.addTag( "type", "Slides" );
        catalog.add( doc );
        CatalogUtil.save( catalog );
    }
    public static void testLoadView() {
        try {
            Catalog catalog = CatalogUtil.load( "C:/Users/User/IdeaProjects/Laborator5[PA]/catalog.ser" );
            System.out.println( catalog.toString() );
            Document doc = catalog.findById( "java1" );
            CatalogUtil.view(doc);

        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }
    }


}
