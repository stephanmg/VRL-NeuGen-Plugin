/// package's name
package edu.gcsc.vrl.NeuGen;

/// imports
import eu.mihosoft.vrl.io.IOUtil;
import eu.mihosoft.vrl.io.VersionInfo;
import eu.mihosoft.vrl.system.InitPluginAPI;
import eu.mihosoft.vrl.system.PluginAPI;
import eu.mihosoft.vrl.system.PluginDependency;
import eu.mihosoft.vrl.system.PluginIdentifier;
import eu.mihosoft.vrl.system.ProjectTemplate;
import eu.mihosoft.vrl.system.VPluginAPI;
import eu.mihosoft.vrl.system.VPluginConfigurator;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @brief NeuGen's plugin configurator for VRL-Studio
 * @author stephanmg <stephan@syntaktischer-zucker.de>
 */
public class NeuGenPluginConfigurator extends VPluginConfigurator {
	/// members
	private File templateProjectSrc;
	public static File resourcePath;

	/**
	 *
	 */
	public NeuGenPluginConfigurator() {
		setIdentifier(new PluginIdentifier("NeuGen-Plugin", "0.1"));
		setDescription("NeuGen VRL Plugin");
		setCopyrightInfo("NeuGen-Plugin",
			"(c) stephanmg", "www.syntaktischer-zucker.de", "LGPLv3", "");
		addDependency(new PluginDependency("VRL", "0.4.2.7", VersionInfo.UNDEFINED));

	}

	/**
	 * @brief
	 * @param api
	 */
	@Override
	public void register(PluginAPI api) {

		// register plugin with canvas
		if (api instanceof VPluginAPI) {
			VPluginAPI vapi = (VPluginAPI) api;
			vapi.addComponent(NeuGenComponent.class);
		}
	}

	/**
	 * @brief
	 * @param api
	 */
	@Override
	public void unregister(PluginAPI api) {
		// nothing to unregister
	}

	/**
	 * @brief
	 * @param iApi
	 * @todo add template project
	 */
	@Override
	public void init(InitPluginAPI iApi) {
		resourcePath = iApi.getResourceFolder();
		/// initTemplateProject(iApi);
	}

	/**
	 * @brief
	 * @param api
	 */
	@Override
	public void install(InitPluginAPI api) {
		new File(api.getResourceFolder(), "template-01.vrlp").delete();
	}

	/**
	 * @brief
	 * @param api
	 */
	private void initTemplateProject(InitPluginAPI api) {
		templateProjectSrc = new File(api.getResourceFolder(), "template-01.vrlp");

		if (!templateProjectSrc.exists()) {
			saveProjectTemplate("/edu/gcsc/vrl/NeuGen/resources/projects/" + "template-01.vrlp");
		}

		api.addProjectTemplate(new ProjectTemplate() {
			@Override
			public String getName() {
				return "NeuGen - Template #1";
			}

			@Override
			public File getSource() {
				return templateProjectSrc;
			}

			@Override
			public String getDescription() {
				return "Template project to generate"
					+ "and export a NeuGen network";
			}

			@Override
			public BufferedImage getIcon() {
				return null;
			}
		});
	}

	/**
	 * @brief
	 * @param str
	 */
	private void saveProjectTemplate(String str) {
		InputStream in = NeuGenPluginConfigurator.class.getResourceAsStream(str);

		try {
			IOUtil.saveStreamToFile(in, new File(str));
		} catch (FileNotFoundException ex) {
			System.err.println(ex);
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
