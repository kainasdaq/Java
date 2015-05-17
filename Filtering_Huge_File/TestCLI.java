import org.apache.commons.cli.*;

public class TestCLI {
	private boolean gf_g = false;
	private boolean gf_r = false;
	private boolean gf_p = false;
	private boolean gf_c = false;
	
	private void usage(Options opts) {
		String header = "Please provide at least one option\n\n";
		String footer = "\nPlease report issues at kdeng6728 at gmail\n\n";

		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("java Solution", header, opts, footer, true);
		System.exit(1);
	}
	
	private void parserArgs(String[] args) {		
		Options options = new Options();
		// add t option
		options.addOption(OptionBuilder.withLongOpt("gender")
	    	.withDescription("Remove gender-inappropriate items").create('g'));
	    options.addOption(OptionBuilder.withLongOpt("highroller")
	    	.withDescription("Remove high roller items").create('r'));
	    options.addOption(OptionBuilder.withLongOpt("pet")
	    	.withDescription("Remove pet items for non pet owners").create('p'));
	    options.addOption(OptionBuilder.withLongOpt("notCA")
	    	.withDescription("Remove \"not available in CA\" items for CA users").create('c'));
	    options.addOption(OptionBuilder.withLongOpt("help")
	    	.withDescription("Print this help message").create('h'));
	    
	    if (0 == args.length) {
			usage(options);
			return;			
		}
		
	    CommandLineParser parser = new PosixParser();
	    
		try {
			CommandLine cmd = parser.parse(options, args);
			
			/*
			int value = 0; // initialize to some meaningful default value
			if (cmd.hasOption("integer-option")) {
				value = ((Number)cmd.getParsedOptionValue("integer-option")).intValue();
			}
			System.out.println(value);
			*/
			
			if ( cmd.hasOption("g") ) {
				gf_g = true;
			} 
		
			if ( cmd.hasOption("r") ) {
				gf_r = true;
			} 
		
			if ( cmd.hasOption("p") ) {
				gf_p = true;
			} 
		
			if ( cmd.hasOption("c") ) {
				gf_c = true;
			}
		
		} catch ( ParseException exp ) {
			System.err.println("\nParsing of command line args failed.  Reason: " 
				+ exp.getMessage() + "\n");
			usage(options);
		}				
	}	
	
	public static void main(String[] args) {
		TestCLI t = new TestCLI();
		t.parserArgs(args);
	}	
}
