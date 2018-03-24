import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.ClassReader;

public class ClassTransformer implements ClassFileTransformer
{
	boolean shouldExecute = true;
	ValidFile vf = new ValidFile();


	public byte[] transform(ClassLoader loader, String cname, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException
	{
		

		//System.out.println(cname);
		

		if(vf.isValid(cname) == true)
		{
			System.out.println(cname);
			ClassReader cr = new ClassReader(classfileBuffer);
			ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
			ClassVisitorModifier classMod = new ClassVisitorModifier(cw);
			cr.accept(classMod, 0);
			return cw.toByteArray();

		}
		else
		{
			return classfileBuffer;
		}	
	
	}

	
}