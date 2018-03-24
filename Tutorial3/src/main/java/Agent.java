import java.lang.instrument.Instrumentation;

public class Agent
{
	public static void premain(String agentArgs, Instrumentation inst)
	{
		//ClassTransformer transformer = new ClassTransformer(agentArgs);

		ClassTransformer transformer = new ClassTransformer();

		inst.addTransformer(transformer);

		Runtime.getRuntime().addShutdownHook(new Thread() {

		@Override
		public void run() 
		{
			
			//transformer.printCoverage();
		}

		});
	}
}