package practice;

/**
 * 제네릭 오버로딩 예제
 * 오버로딩 된 메소드는 컴파일 시점에 어떤 메서드를 호출할지 이미 정해짐
 * 하지만 T 타입은 컴파일 시점에는 아직 어떤 타입인지 모르니 Object 타입이 됨
 * T 타입이 확정될 때는 런타임시
 *
 */

class GenericOverloadingExample {
  public static void main(String[] args) {
    new Container<>(42).display();  // Integer 타입
    new Container<>("Hello").display();  // String 타입
  }

  public static class Container<T> {
    T value;

    public Container(T value) {
      this.value = value;
    }

    public void display() {
      new Handler().handle(value);
    }

    class Handler {
      void handle(Integer num) {
        System.out.println("Integer handling: " + num);
      }

      void handle(String str) {
        System.out.println("String handling: " + str);
      }

      void handle(Object obj) {
        System.out.println("Object handling: " + obj);
      }
    }
  }
}