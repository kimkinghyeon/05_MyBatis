package com.ohgiraffers.section01.xmlmapper;

import java.util.Scanner;

public class Application01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ElementTestService elementTestService = new ElementTestService();

        do {
            System.out.println("==== 매퍼 element 테스트 메뉴 ====");
            System.out.println("1. <cache> 테스트");
            System.out.println("2. <resultMap> 서브메뉴");
            System.out.println("3. <sql> 테스트");
            System.out.println("4. <insert> 서브메뉴");
            System.out.println("5. 종료");
            System.out.print("메뉴를 입력 : ");
            int no = sc.nextInt();
            switch (no) {
                case 1:
                    elementTestService.selectCacheTest();
                    break;
                case 2:
                    resultMapSubMenu();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println( " service ");
                    return;
            }
        } while (true);
    }

    private static void resultMapSubMenu() {
        Scanner sc = new Scanner(System.in);
        ElementTestService elementTestService = new ElementTestService();
        do{
            System.out.println("==== <resultMap> 서브메뉴 ====");
            System.out.println("1. resultMap");
            System.out.println("2. constructor");
            System.out.println("3. association");
            System.out.println("4. collection");
            System.out.println("5 이전");
            System.out.print("메뉴 입력 : ");
            int no = sc.nextInt();

            switch (no){
                case 1: elementTestService.selectResultMapTest();break;
                case 2:elementTestService.selectResultMapConstructorTest();break;
                case 3: elementTestService.selectResultMapAssociationTest();break;
                case 4: elementTestService.selectResultMapCollectionTest();break;
                case 5: return;
            }
        } while (true);
    }
}
