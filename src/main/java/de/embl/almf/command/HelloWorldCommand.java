/*
 * To the extent possible under law, the ImageJ developers have waived
 * all copyright and related or neighboring rights to this tutorial code.
 *
 * See the CC0 1.0 Universal license for details:
 *     http://creativecommons.org/publicdomain/zero/1.0/
 */

package de.embl.almf.command;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.scijava.Context;
import org.scijava.ItemIO;
import org.scijava.app.App;
import org.scijava.app.AppService;
import org.scijava.command.Command;
import org.scijava.command.CommandService;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.plugin.PluginInfo;
import org.scijava.plugin.SciJavaPlugin;
import org.scijava.ui.UIService;


import net.imagej.Dataset;
import net.imagej.ImageJ;
import net.imagej.ops.OpService;
import net.imglib2.RandomAccessibleInterval;
import net.imglib2.img.Img;
import net.imglib2.type.numeric.RealType;

/**
 * This example illustrates how to create an ImageJ {@link Command} plugin.
 * <p>
 * The code here is a simple Gaussian blur using ImageJ Ops.
 * </p>
 * <p>
 * You should replace the parameter fields with your own inputs and outputs,
 * and replace the {@link run} method implementation with your own logic.
 * </p>
 */
@Plugin(type = Command.class, menuPath = "Plugins>Hello world")
public class HelloWorldCommand<T extends RealType<T>> implements Command {
    //
    // Feel free to add more parameters here...
    //

    //@Parameter
    //private Dataset currentData;

    @Parameter
    private UIService uiService;
    
    @Parameter(type=ItemIO.OUTPUT)
    private String out;
    
    

    //@Parameter
    //private OpService opService;

    @Override
    public void run() {
        /*final Img<T> image = (Img<T>)currentData.getImgPlus();

        //
        // Enter image processing code here ...
        // The following is just a Gauss filtering example
        //
        final double[] sigmas = {1.0, 3.0, 5.0};

        List<RandomAccessibleInterval<T>> results = new ArrayList<>();

        for (double sigma : sigmas) {
            results.add(opService.filter().gauss(image, sigma));
        }

        // display result
        for (RandomAccessibleInterval<T> elem : results) {
            uiService.show(elem);
        }
        */
    	
    	System.out.println("Hello world!");
    	uiService.showDialog("Hello world 2");
    	uiService.show("Hi");
    	out="Hi 2";
    }

    /**
     * This main function serves for development purposes.
     * It allows you to run the plugin immediately out of
     * your integrated development environment (IDE).
     *
     * @param args whatever, it's ignored
     * @throws Exception
     */
    public static void main(final String... args) throws Exception {
        Context context=new Context();
        
        CommandService csLowLevel = context.service(CommandService.class);
    	
    	
    	// create the ImageJ application context with all available services
        final ImageJ ij = new ImageJ();
        CommandService cs = ij.command();
        
         AppService myapp = ij.app();
         
         Map<String, App> apps = myapp.getApps();
        
        ij.ui().showUI();
        ij.ui().show(apps);
        System.out.println(apps);
        String imageJGroupId = apps.get("ImageJ").getGroupId();
        App app = apps.get("ImageJ");
        System.out.println(imageJGroupId);
        
        
        PluginInfo<SciJavaPlugin> myPlugin = ij.plugin().getPlugin(HelloWorldCommand.class);
        System.out.println(myPlugin);
//        // ask the user for a file to open
//        final File file = ij.ui().chooseFile(null, "open");
//
//        if (file != null) {
//            // load the dataset
//            final Dataset dataset = ij.scifio().datasetIO().open(file.getPath());
//
//            // show the image
//            ij.ui().show(dataset);
//
//            // invoke the plugin
//            ij.command().run(HelloWorldCommand.class, true);
//        }
    }

}
