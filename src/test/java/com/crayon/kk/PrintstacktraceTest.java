package com.crayon.kk;

/**
 * 基本数据类型和创建新的引用类型的形参在方法中操作都不会改变实参的数据。 改变引用数据类型的某个值实参会同步该改变。
 *
 * @Author 张海锋
 * @Date 2021/6/1 10:01
 */
public class PrintstacktraceTest {

    public static void main(String[] args) {
        TestDemo demo = new TestDemo(1,"测试");
        changeData(demo);
        //TestDemo{code=11, name='测试'}
        System.out.println(demo);
    }

    private static void changeData(TestDemo demo) {
        demo.setCode(11);
        //The value new TestDemo(2,"测试2") assigned to 'demo' is never used
        demo = new TestDemo(2,"测试2");
    }
    static class TestDemo{
        private int code;
        private String name;

        public TestDemo(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "TestDemo{" +
                    "code=" + code +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
