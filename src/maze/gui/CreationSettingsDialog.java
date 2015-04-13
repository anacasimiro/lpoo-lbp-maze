package maze.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner.DefaultEditor;

import maze.logic.DragonType;
import maze.logic.Maze;
import maze.logic.Settings;

/**
 * A class that represents the settings dialog for the creation mode
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public class CreationSettingsDialog extends SettingsDialog {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Creates a new instance of the class
	 *
	 */
	public CreationSettingsDialog() {
		super(new Settings());
	}
	
	
	@Override
	protected void createWidgets() {
		
		// Maze Dimension
		
		mazeDimensionLabel = new JLabel("Maze Dimension:");
		mazeDimensionSpinner = new JSpinner( new SpinnerNumberModel(7, 7, 31, 2) );
		DefaultEditor mazeDimensionTextField = (DefaultEditor)mazeDimensionSpinner.getEditor();
		mazeDimensionTextField.getTextField().setEditable(false);
		mazeDimensionSpinner.setValue( mazeSettings.getMazeDimension() );
		
		
		// Dragons Type
		
		dragonsTypeLabel = new JLabel("Dragons type:");
		dragonsTypeComboBox = new JComboBox<DragonType>(DragonType.values());
		dragonsTypeComboBox.setSelectedItem( mazeSettings.getDragonsType() );	
		
		
		// Save Button
		
		saveButton = new JButton("OK");
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				mazeSettings.setMazeDimension( (Integer)mazeDimensionSpinner.getValue() );
				mazeSettings.setNumberOfDragons( 0 );
				mazeSettings.setNumberOfSwords( 0 );
				mazeSettings.setNumberOfShields( 0 );
				mazeSettings.setDragonsType( (DragonType)dragonsTypeComboBox.getSelectedItem() );
				
				Launcher.frame.setContentPane( new CreationPanel( new Maze(mazeSettings) ) );
				Launcher.frame.setResizable(false);
				Launcher.frame.pack();
				Launcher.frame.setLocationRelativeTo(null);
				
				dispose();
				
			}
			
		});
		
		
		// Cancel Button
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
	}
	

	@Override
	protected void addWidgets() {
		
		panel.add(mazeDimensionLabel);
		panel.add(mazeDimensionSpinner);

		panel.add(dragonsTypeLabel);
		panel.add(dragonsTypeComboBox);
		
		panel.add(saveButton);
		panel.add(cancelButton);
		
	}
	
}
