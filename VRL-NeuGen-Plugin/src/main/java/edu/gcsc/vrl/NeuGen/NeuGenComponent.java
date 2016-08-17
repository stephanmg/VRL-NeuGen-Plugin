/// package's name
package edu.gcsc.vrl.NeuGen;

/// imports
import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.annotation.ParamInfo;
import eu.mihosoft.vrl.system.VMessage;
import java.io.File;
import java.io.Serializable;
import org.neugen.backend.*;
import org.neugen.gui.NeuGenConstants;

/**
 * @brief NeuGen component 
 * @author stephanmg <stephan@syntaktischer-zucker.de>
 * Note: neugenBackend member must be static - otherwise it 
 * might not be initialized in the first run ~~> alternative:
 * check for null and initialize in public methods (cf. below)
 */
@ComponentInfo(name = "NeuGenComponent", category = "Neuro/NeuGen/")
public class NeuGenComponent implements Serializable {
	/// svUID
	private static final long serialVersionUID = 1L;

	/// members 
	private final static NGBackend neugenBackend = new NGBackend();
	private String projectName;
	
	/**
	 * @brief open a NeuGen project
	 * @param inputFolder 
	 */
	public void open_project(
		@ParamInfo(name = "Input project folder", typeName = "Location input", style = "load-folder-dialog")
		File inputFolder) {
		neugenBackend.create_and_open_project(
				NeuGenPluginConfigurator.resourcePath
				+ "/" + projectName, "", NeuGenConstants.NEOCORTEX_PROJECT,
				true, true
			);
	}
	
	/**
	 * @brief create a new NeuGen project with given name and open it
	 * Caution: If project exists with given name, will be overriden!
	 * @param networkType
	 * @param distSynapse
	 * @param nPartsDensity
	 * @param projectName
	 */
	public void open_and_create_project(
		@ParamInfo(name = "Network type", typeName = "Type of NeuGen network",
			style = "selection", options = "value=[\"Neocortex\", \"Hippcampus\"]") String networkType,
		@ParamInfo(name = "Dist synapse", typeName = "Distance threshold for synapse formation") double distSynapse,
		@ParamInfo(name = "n-parts density", typeName = "Density of compartments 1/µm") double nPartsDensity,
		@ParamInfo(name = "Name of project", typeName = "Name of NeuGen project") String projectName
	) {
		 neugenBackend.create_and_open_project(
				NeuGenPluginConfigurator.resourcePath
				+ "/" + projectName, "", NeuGenConstants.NEOCORTEX_PROJECT,
				true, false 
			);
		neugenBackend.modifyNPartsDensity(nPartsDensity);
		neugenBackend.generate_network();
		this.projectName = NeuGenPluginConfigurator.resourcePath + "/" + projectName;
	}

	/**
	 * @brief export a NeuGen network
	 * Note: The network generation may be expensive, therefore
	 * one needs to call generate_network before using export_network.
	 * @param exportFormat
	 * @param outputFolder
	 * @param outputName
	 */
	public void export_network(
		@ParamInfo(name = "Export format",
			typeName = "Format for exporting NeuGen network",
			style = "selection",
			options = "value=[\"TXT\", \"NGX\"]") String exportFormat,
		@ParamInfo(name = "Output folder", typeName = "Location output", style = "save-folder-dialog") File outputFolder,
		@ParamInfo(name = "Output name", typeName = "Output name") String outputName
	) {

		if (outputFolder.isDirectory()) {
			neugenBackend.export_network(exportFormat, outputFolder + "/" + outputName + "." + exportFormat.toLowerCase(), false);
		} else {
			VMessage.info("Export network", "Given folder: " 
				+ outputFolder.toString() + " does not exist. "
				+ "Therefore network export is not possible.");
		}
	}
	
	/**
	 * @brief generate a NeuGen network
	 */
	public void generate_network() {
		neugenBackend.generate_network();
	}

	/**
	 * @brief save a NeuGen network project
	 * Note: Useful if you want to open another project and
	 * save the modified network to project file 
	 */
	public void save_project() {
		neugenBackend.save_project();
	}
	
	/**
	 * @brief close a NeuGen network project without saving
	 */
	public void close_project() {
		neugenBackend.close_project();
		this.projectName = "";
	}
	
	/**
	 * @brief close a NeuGen network project with saving
	 */
	public void save_and_close_project() {
		save_project();
		close_project();
	}

	/**
	 * @brief reset all unsaved changes made to the current open project
	 */
	public void reset_project() {
		neugenBackend.reset_project();
	}
		
	/**
	 * @brief adjust network size
	 * @param factor
	 */
	public void set_network_size(
		@ParamInfo(name = "Network size", typeName = "Size of network (cell count)")
		int factor
	) {
		neugenBackend.adjustNetworkSize(factor);
	}
	
	/**
	 * @brief set cell counts for cell types in a neocortex network
	 * @param starPyramidal
	 * @param l4Stellate
	 * @param l23Pyramidal
	 * @param l5APyramidal
	 * @param l5BPyramidal 
	 */
	public void setup_neocortex_network(
		@ParamInfo(name = "L4 STAR PYRAMIDAL", typeName = "Hippocampal Layer 4 STAR PYRAMIDAL cell (default 0 cells)",
			   style="slider", options="min=0; max=100; value=0")
		int starPyramidal,
		@ParamInfo(name = "L4 STELLATE", typeName = "Hippocampal Layer 4 STELLATE cell (default 5 cells)",
			   style="slider", options="min=0; max=100; value=5")
		int l4Stellate,
		@ParamInfo(name = "L23 PYRAMIDAL", typeName = "Hippocampal Layer 2/3 PYRAMIDAL cell (default 3 cells)",
			   style="slider", options="min=0; max=100; value=3")
		int l23Pyramidal,
		@ParamInfo(name = "L5A PYRAMIDAL", typeName = "Hippocampal Layer 5A PYRAMIDAL cell (default 2 cells)",
			   style="slider", options="min=0; max=100; value=2")
		int l5APyramidal,
		@ParamInfo(name = "L5B PYRAMIDAL", typeName = "Hippocampal Layer 5B PYRAMIDAL cell (default 2 cells)",
			   style="slider", options="min=0; max=100; value=2")
		int l5BPyramidal
		
	)  {
		neugenBackend.adjust_number_of_star_pyramidal_cells(starPyramidal);
		neugenBackend.adjust_number_of_stellate_cells(l4Stellate);
		neugenBackend.adjust_number_of_layer_23_pyramidal(l23Pyramidal);
		neugenBackend.adjust_number_of_layer_5_a_pyramidal(l5APyramidal);
		neugenBackend.adjust_number_of_layer_5_b_pyramidal(l5BPyramidal);
	}
}
