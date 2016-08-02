/// package's name
package edu.gcsc.vrl.NeuGen;

/// imports
import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.annotation.ParamInfo;
import java.io.File;
import java.io.Serializable;
import java.util.Map;
import org.neugen.backend.*;
import org.neugen.datastructures.xml.XMLObject;
import org.neugen.gui.NeuGenConstants;

/**
 * @brief NeuGen component for VRL-Studio
 * @author stephanmg <stephan@syntaktischer-zucker.de>
 * Note: The params map will be refactored soon into the NeuGen' pseudo-backend
 */
@ComponentInfo(name = "NeuGenComponent", category = "Neuro/NeuGen")
public class NeuGenComponent implements Serializable {
	/// svUID
	private static final long serialVersionUID = 1L;

	/// members
	private static final NGBackend neugenBackend = new NGBackend();
	private String projectName;
	private Map<String, XMLObject> params; 

	
	/**
	 * @brief open a NeuGen network
	 * @param inputFolder 
	 */
	public void open_network(
		@ParamInfo(name = "Output folder", typeName = "Location output", style = "load-folder-dialog")
		File inputFolder) {
		this.params	= neugenBackend.create_and_open_project(
				NeuGenPluginConfigurator.resourcePath
				+ "/" + projectName, "", NeuGenConstants.NEOCORTEX_PROJECT,
				true, true
			);
	}
	
	/**
	 * @brief generate a NeuGen network
	 * @param networkType
	 * @param distSynapse
	 * @param nPartsDensity
	 * @param projectName
	 */
	public void generate_network(
		@ParamInfo(name = "Network type", typeName = "Type of NeuGen network",
			style = "selection", options = "value=[\"Neocortex\", \"Hippcampus\"]") String networkType,
		@ParamInfo(name = "Dist synapse", typeName = "Distance threshold for synapse formation") double distSynapse,
		@ParamInfo(name = "n-parts density", typeName = "Density of compartments 1/µm") double nPartsDensity,
		@ParamInfo(name = "Name of project", typeName = "Name of NeuGen project") String projectName
	) {
		this.params	= neugenBackend.create_and_open_project(
				NeuGenPluginConfigurator.resourcePath
				+ "/" + projectName, "", NeuGenConstants.NEOCORTEX_PROJECT,
				true, false
			);
		neugenBackend.modifyNPartsDensity(params,
			NeuGenPluginConfigurator.resourcePath + "/" + projectName + "/" + networkType, nPartsDensity);
		neugenBackend.generate_network(NeuGenConstants.NEOCORTEX_PROJECT);
		this.projectName = NeuGenPluginConfigurator.resourcePath + "/" + projectName;
	}

	/**
	 * @brief export a NeuGen network
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
		neugenBackend.export_network(exportFormat, outputFolder + "/" + outputName + "." + exportFormat.toLowerCase(), false);
	}

	/**
	 * @brief save a NeuGen network
	 */
	public void save_network() {
		neugenBackend.save_and_close_project(this.params, this.projectName);
	}
}
