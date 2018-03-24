import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import java.io.*;

public class ClassVisitorModifier extends ClassVisitor implements Opcodes
{
	private String className;

	public ClassVisitorModifier(ClassVisitor cv)
	{
		super(Opcodes.ASM5, cv);
		
	}

	@Override
	public void visit(int version, int access, String cname, String signature, String superName, String[] interfaces)
	{
		super.visit(version, access, cname, signature, superName, interfaces);
		this.className = cname;
	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions)
	{
		MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
		
		if(mv != null)
		{
			return new MethodVisitorModifier(mv, className, name);
		}
		else
		{
			return null;
		}
	}

	@Override
	public void visitEnd()
	{
		super.visitEnd();
	}
}
