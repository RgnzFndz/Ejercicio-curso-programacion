public class EngineFactory {
    public Engine CreateEngine(String imgPath, String name, int year, int hp, int cc)
    {
        Engine engine = new Engine(imgPath, name, year, hp, cc);
        return engine;
    }
}
