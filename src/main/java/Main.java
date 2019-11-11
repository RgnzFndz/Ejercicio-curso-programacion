public class Main {
    public static void main(String[] args) {       
       EngineFactory factory = new EngineFactory();
       Engine engine1 = factory.CreateEngine("src/main/java/Panhead.jpg", "Panhead", 1948, 55, 990);
       Engine engine2 = factory.CreateEngine("src/main/java/Revolution.png", "Revolution", 2002, 117, 1130);
       Engine engine3 = factory.CreateEngine("src/main/java/Shovelhead.png", "Shovelhead", 1966, 60, 1200);

       Engine[] engines = new Engine[]{engine1, engine2, engine3};
       
       EngineGallery gallery = new EngineGallery(engines);
       
       gallery.setVisible(true);
    }    
}
