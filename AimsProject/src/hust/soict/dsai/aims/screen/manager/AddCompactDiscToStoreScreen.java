package hust.soict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.disc.CompactDisc;
import hust.soict.dsai.aims.media.track.Track;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.screen.manager.AddItemToStoreScreen;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen{
	private JTextField artistTF;
	private List<TrackField> trackEntry = new ArrayList<TrackField>();
	private JPanel addTrackPanel;
	
	public AddCompactDiscToStoreScreen(Store store) {
		super(store);
	}
	
	@Override
	public JPanel createCenter() {
		JPanel center = new JPanel();
		CDEntry cdEntry = new CDEntry();
		center.setLayout(new FlowLayout());
		center.add(cdEntry.createTitle());
		center.add(cdEntry.createCategory());
		center.add(cdEntry.createCost());
		center.add(cdEntry.createArtist());
		center.add(createTrackPanel());
		
		return center;
	}
	public JPanel createTrackPanel() {
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		
		setAddTrackPanel();
		
		jp.add(addTrackPanel, BorderLayout.CENTER);
		JScrollPane editorScrollPane = new JScrollPane(addTrackPanel);
		editorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		editorScrollPane.setPreferredSize(new Dimension(600, 500));
		editorScrollPane.setMinimumSize(new Dimension(600, 500));
		jp.add(editorScrollPane); 
		
		
		JPanel moreButPanel = new JPanel();
		moreButton moreBut = new moreButton();
		moreButPanel.add(moreBut);
		jp.add(moreButPanel, BorderLayout.SOUTH);
		
		return jp;
	}
	
	
	public void setAddTrackPanel() {
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(4, 4, 2, 2));
		addTrackPanel = jp;
		
	}
	
	
	@Override 
	public void createMedia() {
		String title = titleTF.getText();
		String category = categoryTF.getText();
		String artist = artistTF.getText();
		Float cost = Float.parseFloat(costTF.getText());
		
		CompactDisc cd = new CompactDisc(title, category, artist, cost);
		for (TrackField trackField: trackEntry) {
			String trackTitle = trackField.getTitle();
			int trackLen = Integer.parseInt(trackField.lengthTF.getText());
			cd.addTrack(new Track(trackTitle, trackLen));
		}
		super.setMedia(cd);
	}
	
	private class CDEntry extends MediaEntry {
		JPanel createArtist() {
			JPanel jp = new JPanel();
			jp.setLayout(new FlowLayout());
		
			jp.add(new JLabel("Enter the artist: "));
		
			artistTF = new JTextField(25);
		
			jp.add(artistTF);
			return jp;
		}
	}
	private class moreButton extends JButton implements ActionListener{
		moreButton() {
			super();
			setText("More >>");
			addActionListener(this);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			TrackField trackField = new TrackField();
			addTrackPanel.add(trackField);
			trackEntry.add(trackField);
			AddCompactDiscToStoreScreen.this.revalidate();
		}
		
	}
	
	protected class TrackField extends JPanel{
		//static int tag;
		private JLabel label;
		JTextField titleTF = new JTextField(6);
		private JTextField lengthTF = new JTextField(3);
		
		public TrackField() {
			//tag ++;
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			this.add(Box.createVerticalGlue());
			JPanel[] line = new JPanel[3];
			//JPanel innerPanel = new JPanel();
			//innerPanel.setLayout(new GridLayout(3, 2, 2, 2));
			
			for (int i = 0; i < 3; i ++) {
				line[i] = new JPanel();
			}
			
			label = new JLabel("Track " + (trackEntry.size() + 1));
			label.setAlignmentX(LEFT_ALIGNMENT);
			line[0].add(label);
			
			
			label = new JLabel("Title: ");
			label.setAlignmentX(LEFT_ALIGNMENT);
			line[1].add(label);
			//titleTF 
			line[1].add(titleTF);
			
			
			label = new JLabel("Length: ");
			label.setAlignmentX(LEFT_ALIGNMENT);
			line[2].add(label);
			//lengthTF = new JTextField(3);
			line[2].add(lengthTF);
			
			
			for (int i = 0; i < 3; i ++) {
				this.add(line[i]);
			}
			//this.add(innerPanel);
			
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
			
		}
		public String getTitle() {
			return titleTF.getText();
		}
	}
	
}
