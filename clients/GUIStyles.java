package clients;

import javax.swing.UIManager;
import javax.swing.BorderFactory;
import javax.swing.plaf.ColorUIResource;
import java.awt.Color;
import java.awt.Font;

public class GUIStyles {
    // 2000s Argos inspired colour scheme
    private static final Color ARGOS_DARK_BLUE = new Color(0, 51, 102);    // Dark header blue
    private static final Color ARGOS_MID_BLUE = new Color(0, 102, 204);    // Button blue
    private static final Color ARGOS_LIGHT_BLUE = new Color(230, 241, 255);// Light background
    private static final Color ARGOS_RED = new Color(204, 0, 0);          // Classic Argos red
    
    public static void setupLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            // Window and panels
            UIManager.put("Panel.background", ARGOS_LIGHT_BLUE);
            UIManager.put("Frame.background", ARGOS_LIGHT_BLUE);
            
            // Title labels 
            UIManager.put("Label.font", new Font("Arial", Font.BOLD, 14));
            UIManager.put("Label.foreground", ARGOS_DARK_BLUE);
            
            // Buttons
            UIManager.put("Button.background", ARGOS_MID_BLUE);
            UIManager.put("Button.foreground", Color.WHITE);
            UIManager.put("Button.font", new Font("Arial", Font.BOLD, 12));
            UIManager.put("Button.select", ARGOS_DARK_BLUE);
            UIManager.put("Button.focus", ARGOS_RED);
            UIManager.put("Button.border", BorderFactory.createRaisedBevelBorder());
            
            // Text fields
            UIManager.put("TextField.background", Color.WHITE);
            UIManager.put("TextField.foreground", Color.BLACK);
            UIManager.put("TextField.caretForeground", ARGOS_DARK_BLUE);
            UIManager.put("TextField.border", BorderFactory.createLineBorder(ARGOS_MID_BLUE));
            UIManager.put("TextField.font", new Font("Arial", Font.PLAIN, 12));
            
            // Text areas
            UIManager.put("TextArea.background", Color.WHITE);
            UIManager.put("TextArea.foreground", Color.BLACK);
            UIManager.put("TextArea.font", new Font("Arial", Font.PLAIN, 12));
            
            // Scroll panes
            UIManager.put("ScrollPane.background", Color.WHITE);
            UIManager.put("ScrollPane.border", BorderFactory.createLineBorder(ARGOS_MID_BLUE));
            
            // Selection colors
            UIManager.put("TextField.selectionBackground", ARGOS_MID_BLUE);
            UIManager.put("TextField.selectionForeground", Color.WHITE);
            UIManager.put("TextArea.selectionBackground", ARGOS_MID_BLUE);
            UIManager.put("TextArea.selectionForeground", Color.WHITE);
            
        } catch (Exception e) {
            System.out.println("Error setting Look and Feel: " + e.getMessage());
        }
    }
}