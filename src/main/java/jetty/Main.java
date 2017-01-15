package jetty;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.FragmentConfiguration;
import org.eclipse.jetty.webapp.JettyWebXmlConfiguration;
import org.eclipse.jetty.webapp.MetaInfConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

public class Main {
	public static void main(String[] args) throws Exception {
		if(args.length != 1){
			throw new Exception("require war file");
		}

		WebAppContext war = new WebAppContext();
		war.setWar(args[0]);

		Configuration[] configurations = { //
				new AnnotationConfiguration(), //
				new WebInfConfiguration(), //
				new WebXmlConfiguration(), //
				new MetaInfConfiguration(), //
				new FragmentConfiguration(), //
				new EnvConfiguration(), //
				new PlusConfiguration(), //
				new JettyWebXmlConfiguration()//
		};
		war.setConfigurations(configurations);

		Server server = new Server(8080);
		server.setHandler(war);
		server.start();
		server.join();
	}
}
