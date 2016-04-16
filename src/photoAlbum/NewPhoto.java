package photoAlbum;

//import java.awt.BorderLayout;
//import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class NewPhoto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JTextArea textArea;
	JLabel photo;
	private JLabel label_1;
	private JLabel label_2;
	String Name;
	
	/**
	 * Create the frame.
	 */
	public NewPhoto(String name,int i) {
		super("Image");
		Name = name;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 787, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		photo = new JLabel("");
		photo.setBounds(131, 33, 477, 294);
		SetImageSize(photo,Name);
		contentPane.add(photo);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(75, 341, 46, 14);
		contentPane.add(lblTitle);
		
		JLabel lblAnnotation = new JLabel("Annotation");
		lblAnnotation.setBounds(75, 374, 75, 14);
		contentPane.add(lblAnnotation);
		
		textField = new JTextField();
		textField.setBounds(165, 338, 399, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(164, 369, 400, 65);
		contentPane.add(textArea);
		
		JButton btnSaveExit = new JButton("Save & Exit");
		btnSaveExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			   if(textField.getText().length()>20)
			   {
				   JOptionPane.showMessageDialog(null, "Title cannot be longer than 20 chars.");
			   }
			   else if(textArea.getText().length()>100)
			   {
				   JOptionPane.showMessageDialog(null, "Annotation cannot be longer than 100 chars."); 
			   }
			   else if(textArea.getText().length()==0||textField.getText().length()==0)
			   {
				   JOptionPane.showMessageDialog(null, "Title / Annotation cannot be empty."); 
			   }
			   else{
				   MainFrame.photos.add(new Photo());
				   int idx = MainFrame.photos.size()-1;
				   MainFrame.photos.get(idx).src = Name;
				   MainFrame.photos.get(idx).title = textField.getText();
				   MainFrame.photos.get(idx).annotation = textArea.getText();
				   MainFrame.label[idx+1].setText("");
				   MainFrame.SetImageSize(MainFrame.label[idx+1],Name);
				   MainFrame.title[idx+1].setText(textField.getText());
				   MainFrame.save();
				   MainFrame.update();
				   MainFrame.updateToolTip();
				   dispose();
			   }
			}
		});
		btnSaveExit.setBounds(610, 370, 130, 23);
		contentPane.add(btnSaveExit);
		
		JButton btnExitWoSaving = new JButton("Exit");
		btnExitWoSaving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnExitWoSaving.setBounds(610, 404, 130, 23);
		contentPane.add(btnExitWoSaving);
		
		label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int idx = find_photo_by_name(Name);
				idx--;
				if(idx<0) return;
				MainFrame.SetImageSize(photo,MainFrame.photos.get(idx).src);
				Name = MainFrame.photos.get(idx).src;
				textField.setText(MainFrame.photos.get(idx).title);
				textArea.setText(MainFrame.photos.get(idx).annotation);
			}
		});
		label_1.setBounds(14, 290, 46, 37);
		contentPane.add(label_1);
		SetImageSizeBin(label_1,"/prev.png");
		
		label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int idx = find_photo_by_name(Name);
				idx++;
				if(idx>=MainFrame.photos.size()) return;
				MainFrame.SetImageSize(photo, MainFrame.photos.get(idx).src);
				textField.setText(MainFrame.photos.get(idx).title);
				textArea.setText(MainFrame.photos.get(idx).annotation);
				Name = MainFrame.photos.get(idx).src;
			}
		});
		label_2.setBounds(701, 290, 46, 37);
		contentPane.add(label_2);
		SetImageSizeBin(label_2,"/next.png");
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 771, 445);
		contentPane.add(label);
		SetImageSizeBin(label,"/bckgd.jpg");
		if(i==2)
		{
			int idx = find_photo_by_name(Name);
			textField.setText(MainFrame.photos.get(idx).title);
			textField.setEditable(false);
			textArea.setText(MainFrame.photos.get(idx).annotation);
			textArea.setEditable(false);
			btnSaveExit.setVisible(false);
			
		}
		else if(i==1)
		{
			label_1.setVisible(false);
			label_2.setVisible(false);
		}
	}
	public static void SetImageSize(JLabel label,String imgName)
	{ 
		ImageIcon icon = new ImageIcon(imgName); 
		Image img = icon.getImage(); 
		Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon newImc = new ImageIcon(newImg); 
		label.setIcon(newImc); 
	}
	public static int find_photo_by_name(String name)
	{
		for(int i=0; i<MainFrame.photos.size(); i++)
		{
			if(MainFrame.photos.get(i).src.equals(name)) return i;
		}
		return 0;
	}
	
	public void SetImageSizeBin(JLabel label,String imgName)
	{ 
		ImageIcon icon = new ImageIcon(this.getClass().getResource(imgName)); 
		Image img = icon.getImage(); 
		Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon newImc = new ImageIcon(newImg); 
		label.setIcon(newImc); 
	}
	public static void rename(String n)
	{
		
	}
}
