import org.objectweb.asm.*;


public class MethodVisitorModifier extends MethodVisitor implements Opcodes
{
	String className;
	String methodName;

	public MethodVisitorModifier(MethodVisitor mv, String cname, String mname)
	{
		super(Opcodes.ASM5, mv);
		this.className = cname;
		this.methodName = mname;

	}

	@Override
	public void visitLineNumber(int line, Label start) throws IllegalArgumentException
	{
//		System.out.println("test2");
		CodeCoverageInformationContainer.insertLine(className, methodName, line);
		mv.visitLdcInsn(className);
		mv.visitLdcInsn(methodName);
		mv.visitLdcInsn(line);
		mv.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
		mv.visitMethodInsn(INVOKESTATIC, "CodeCoverageInformationContainer", "LineExecuted", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", false);
		super.visitLineNumber(line, start);

	}

	@Override
	public void visitEnd()
	{
		super.visitEnd();
	}
}