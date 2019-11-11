import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EngineGallery extends JFrame{
    private JLabel _engineName;
    private JLabel _engineYear;
    private JLabel _engineHP;
    private JLabel _engineCC;    
    private JLabel _engineImage;
    
    public EngineGallery(Engine[] engines){
        super();
        ConfigureWindow();
        InitializeGallery(engines[0]);
        CreateThumbnails(engines);
    }
    
    private void ConfigureWindow() {
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void InitializeGallery(Engine firstEngine){
        _engineName = new JLabel();
        _engineYear = new JLabel();
        _engineHP = new JLabel();
        _engineCC = new JLabel();
        _engineImage = new JLabel();
        
        _engineName.setBounds(425, 0, 150, 50);
        _engineImage.setBounds(250, 50, 400, 400);
        _engineYear.setBounds(775, 50, 200, 50);
        _engineHP.setBounds(775, 100, 200, 50);
        _engineCC.setBounds(775, 150, 200, 50);
        
        ShowEngine(firstEngine);
        
        this.add(_engineName);
        this.add(_engineImage);
        this.add(_engineYear);
        this.add(_engineHP);
        this.add(_engineCC);
    }
    
    private void CreateThumbnails(Engine[] engines){
        for(int i = 0; i < engines.length; i++){
            JButton thumbnail = new JButton();
            thumbnail.setIcon(new ImageIcon(new ImageIcon(engines[i].ImgPath).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
            int x = 200 * i;
            int y = 450;
            thumbnail.setBounds(x, y, 200, 200);
            ThumbnailListener listener = new ThumbnailListener(engines[i], this);
            thumbnail.addActionListener(listener);
            this.add(thumbnail);
        }
    }
    
    public void ShowEngine(Engine engine){
        _engineImage.setIcon(new ImageIcon(new ImageIcon(engine.ImgPath).getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT)));        
        _engineName.setText(engine.Name);
        _engineYear.setText("Year: " + String.valueOf(engine.Year));
        _engineHP.setText("HP: " + String.valueOf(engine.HP));
        _engineCC.setText("CC: " + String.valueOf(engine.CC));
    }
    
    class ThumbnailListener implements ActionListener{
        private Engine _engine = null;
        private EngineGallery _gallery = null;
        public ThumbnailListener(Engine engine, EngineGallery gallery){
            this._engine = engine;
            this._gallery = gallery;
        }
        @Override
        public void actionPerformed(ActionEvent e){
            this._gallery.ShowEngine(this._engine);
        }
    }
}
