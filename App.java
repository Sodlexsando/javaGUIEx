package GUIEx;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;
public class App {
    public static void main(String[]args)throws Exception{
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());


        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Archivo");
        JMenu helpMenu = new JMenu("Ayuda");
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        JMenuItem openItem=new JMenuItem("abrir");
        JMenuItem saveItem = new JMenuItem("guardar como");
        fileMenu.add(openItem);
        helpMenu.add(saveItem);

        JPanel panel = new JPanel();
        JLabel mesagLabel=new JLabel("Mensaje");
        JTextField chatTextField=new JTextField(10);
        JButton sendButton=new JButton("Enviar");
        JButton resetButton = new JButton("restablecer");

        panel.setLayout(new FlowLayout());
        panel.add(mesagLabel);
        panel.add(chatTextField);
        panel.add(sendButton);
        panel.add(resetButton);

        JTextArea chatHistory =new JTextArea();
        chatHistory.setEditable(false);

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, chatHistory);

        sendButton.addActionListener(e-> addMessage(chatTextField.getText(),chatHistory,chatTextField));
        resetButton.addActionListener(e-> resetTextField(chatTextField));
        frame.setVisible(true);

    }

    public static void resetTextField(JTextField target){
        target.setText("null");
    }

    public static void addMessage(String message,JTextArea targTextArea,JTextField targTextField){
        targTextArea.append("\nAlex dice:"+message);
        resetTextField(targTextField);
    }
}
