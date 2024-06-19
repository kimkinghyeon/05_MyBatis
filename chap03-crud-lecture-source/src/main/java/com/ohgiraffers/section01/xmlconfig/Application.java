package com.ohgiraffers.section01.xmlconfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        /*
        시스템 요구사항
        1. 메뉴 전체조회
        2. 메뉴 코드로 메뉴 조회
        3. 신규 메뉴 추가
        4. 메뉴 수정
        5. 메뉴 삭제
        * * */

        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();

        do {
            System.out.println("====== 오지라퍼 메뉴 관리시스템 ======");
            System.out.println(" 시스템 요구사항");
            System.out.println("1. 메뉴 전체조회");
            System.out.println("2. 메뉴 코드로 메뉴 조회");
            System.out.println("3. 신규 메뉴 추가");
            System.out.println("4. 메뉴 수정");
            System.out.println("5. 메뉴 삭제");
            System.out.println("6. 프로그램을 종료");
            System.out.println("==== ==== ==== ==== ==== ==== ====");
            System.out.print("메뉴 관리번호 를 입력 : ");

            int no = sc.nextInt();

            switch (no) {
                case 1:
                    menuController.selectAllMenu();
                    break;
                case 2:
                    menuController.selectMenuByCode(inputMenuCode());
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("입력 값 잘 입력 좀 하셈;;;");
                    break;
            }
        } while (true);

    }

    // 메뉴코드를 입력받는 메서드
    private static Map<String, String> inputMenuCode() {

        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴코드를 입력하세요 : ");
        String code = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);

        return parameter;
    }

}
