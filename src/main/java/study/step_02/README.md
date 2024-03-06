## 숫자 야구

----
 요구사항 분석 (추가 이해가 필요한 요구사항에 대해서만 서술)
> 1. [자바 스타일 가이드](https://github.com/JunHoPark93/google-java-styleguide) : 번역본을 참고하여 학습한다. 다만, 완벽한 학습에 큰 시간이 소요될 경우 큰 주제의 원칙을 지키는 것을 우선으로하고, 코드 작성 후 스타일 가이드에 어긋나는 것이 있는지 재확인 하는 방식으로 학습한다.
> 2. UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다. -> 제대로 이해하지 못함. (학습 대상 : UI 로직이란?, InputView, ResultView란?)
---
 Todo List (Class)
> 1. `BullsAndCowsGame` (게임 실행이 있음 `palyGame()` )
> 2. `Umpire` (심판, 사용자 입력 값을 검증) 볼, 스트라이크, 낫싱, 정답
> 3. `정답` (길이 3의 겹치지 않는 랜덤 한 자리 숫자 배열) 배열 생성 로직.
> 4. `사용자 입력 값` 사용자가 입력 한 문자열 정답과 비교할 수 있는 데이터로 파싱 역할, 예외처리
> 5. `게임 메시지` System.out.println() 으로 담아서 내보내는 문자열을 final로 선언, 관리
> 6. `예외 메시지` 예외 처리용 메시지 final로 선언 관리

Todo List (Method)
> 1. `palyGame()` : 내부에서 Scanner 선언, while(게임중 ture일 때)문 안에서 게임 로직 수행
> 2. `isPlaying()` : 사용자가 게임 종료를 선택하면 false로 변경.
> 3. `정답 생성하는 함수` : 길이 3의 한 자릿 수 숫자 Hash Set 생성 (set의 경우 순서가 없기 때문에 Linked Hash Set || int[]로 변환해서 사용)
> 4. `사용자 답변(String) 파싱하는 함수` : 정답 set과 비교할 수 있도록 
> 5. `사용자 답변과 정답 비교 함수` : while(완전 정답) 일 때 까지 반복, if문으로 내부 구성