package hust.soict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.screen.manager.AddItemToStoreScreen;

public class AddBookToStoreScreen extends AddItemToStoreScreen{
	private JEditorPane contentTEP;
	
	public AddBookToStoreScreen(Store store, Container cp) {
		super(store, cp);
	}
	
	@Override
	public JPanel createCenter() {
		JPanel center = new JPanel();
		BookEntry bookEntry = new BookEntry();
		center.setLayout(new FlowLayout());
		center.add(bookEntry.createTitle());
		center.add(bookEntry.createCategory());
		center.add(bookEntry.createCost());
		center.add(bookEntry.createContent());
		return center;
	}
	@Override 
	public void createMedia() {
		String title = titleTF.getText();
		String category = categoryTF.getText();
		Float cost = Float.parseFloat(costTF.getText());
		
		Book book = new Book(title, category, cost);
		book.setContent(contentTEP.getText());
		super.setMedia(book);
	}
	
	private class BookEntry extends MediaEntry {
		public JPanel createContent() {
			JPanel jp = new JPanel();
			jp.setLayout(new FlowLayout());
		
			jp.add(new JLabel("Enter the content of book: "));
		
			contentTEP = new JEditorPane();
			contentTEP.addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					//System.out.println(contentTEP.getText());
				}
				@Override
				public void focusLost(FocusEvent e) {
					// Load your content.
				}
			});
		
			JScrollPane editorScrollPane = new JScrollPane(contentTEP);
			editorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			editorScrollPane.setPreferredSize(new Dimension(600, 500));
			editorScrollPane.setMinimumSize(new Dimension(600, 500));
			jp.add(editorScrollPane);
			return jp;
		}
	}
	
}
