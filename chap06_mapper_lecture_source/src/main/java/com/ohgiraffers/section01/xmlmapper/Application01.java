package com.ohgiraffers.section01.xmlmapper;

import com.ohgiraffers.common.MenuDTO;

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
                    elementTestService.selectSqlTest();
                    break;
                case 4:
                    insertSubMenu();
                    break;
                case 5:
                    System.out.println("종료");
                    return;
            }
        } while (true);
    }

    private static void resultMapSubMenu() {
        Scanner sc = new Scanner(System.in);
        ElementTestService elementTestService = new ElementTestService();
        do {
            System.out.println("==== <resultMap> 서브메뉴 ====");
            System.out.println("1. resultMap");
            System.out.println("2. constructor");
            System.out.println("3. association");
            System.out.println("4. collection");
            System.out.println("5 이전");
            System.out.print("메뉴 입력 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    elementTestService.selectResultMapTest();
                    break;
                case 2:
                    elementTestService.selectResultMapConstructorTest();
                    break;
                case 3:
                    elementTestService.selectResultMapAssociationTest();
                    break;
                case 4:
                    elementTestService.selectResultMapCollectionTest();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    private static void insertSubMenu() {

        Scanner sc = new Scanner(System.in);
        ElementTestService elementTestService = new ElementTestService();

        do {
            System.out.println("==== <resultMap> 서브메뉴 ====");
            System.out.println("1. insert 테스트 (메뉴등록)");
            System.out.println("2. insert 테스트 (신규 카테고리의 메뉴 등록)");
            System.out.println("5 이전");
            System.out.print("메뉴 입력 : ");
            int no = sc.nextInt();
            switch (no) {
                case 1:
                    elementTestService.insertMenuTset(inputMenu());
                    break;
                case 2:
                   // elementTestService.();
                    break;
                case 5:
                    return;
            }

        } while (true);
    }

    private static MenuDTO inputMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("등록할 메뉴 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("등록할 메뉴 가격을 입력하세요 : ");
        int price = sc.nextInt();
        System.out.print("등록할 카테고리를 입력하세요 : ");
        int categoryCode = sc.nextInt();
        System.out.print("등록할 메뉴 판매가능 여부 입력하세요 : ");
        String orderableStatus = sc.nextLine();

        MenuDTO menu = new MenuDTO();
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);
        menu.setOrderableStatus(orderableStatus);

        return menu;

    }
}
