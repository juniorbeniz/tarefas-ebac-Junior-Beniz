package annotation;

import java.lang.reflect.Method;

public class RunTabela {


    public static void main(String[] args) throws Exception {


        Tab newTab = new Tab();
        Method x = newTab.getClass().getMethod("sayName");
        Tabela myTab = x.getAnnotation(Tabela.class);

        System.out.println("O nome da tabela é: " + myTab.nome());
        System.out.println("Tabela feita por: " + myTab.autor());

    }
}
