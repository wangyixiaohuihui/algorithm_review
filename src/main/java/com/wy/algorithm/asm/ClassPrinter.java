package com.wy.algorithm.asm;

import jdk.internal.org.objectweb.asm.*;

import java.io.IOException;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

/**
 * ClassName ClassPrinter
 * Date 2019/10/23
 *
 * @author wangyi
 **/
public class ClassPrinter extends ClassVisitor {

    public ClassPrinter() {
        super(ASM4);
    }

    @Override
    public void visit(int version, int acess, String name, String signature,
                      String superName, String[] interfaces){
        System.out.println(name +" extends "+ superName+ "{");
    }
    @Override
    public void visitSource(String source, String debug) {

    }
    @Override
    public void visitOuterClass(String owner, String name, String desc) {}


    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        return null;
    }
    @Override
    public void visitAttribute(Attribute attr) {

    }
    @Override
    public void visitInnerClass(String name, String outerName, String innerName, int access) {

    }
    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        System.out.println("    " + desc + " " + name);
        return null;
    }
    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature,
                                     String[] exceptions) {
        System.out.println(" " + name + desc);
        return null;
    }
    @Override
    public void visitEnd() {
        System.out.println("}");
    }


    public static void main(String[] args) {
        ClassPrinter cp = new ClassPrinter();
        ClassReader cr = null;
        try {
            cr = new ClassReader("java.lang.Runnable");
        } catch (IOException e) {
            e.printStackTrace();
        }
        cr.accept(cp, 0);


        /**
         *  使用classWriter 写出一个java类出来
         * ackage pkg;
         * public interface Comparable extends Mesurable {
         *     int LESS = -1;
         *     int EQUAL = 0;
         *     int GREATER = 1;
         *     int compareTo(Object o);
         * }
         */
        ClassWriter cw = new ClassWriter(0);
        cw.visit(V1_5, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
                "pkg/Comparable", null, "java/lang/Object", new String[] { "pkg/Mesurable" });
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC,
                "LESS", "I", null, new Integer(-1)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC,
                "EQUAL", "I", null, new Integer(0)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC,
                "GREATER", "I", null, new Integer(1)).visitEnd();
        cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", null, null).visitEnd(); cw.visitEnd();

        byte[] b = cw.toByteArray();
        Class c = new MyClassLoader().defineClass("pkg.Comparable", b);

    }
}
