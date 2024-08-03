package practice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Chapter10 {

	public static void main(String[] args) throws Exception {
		List<Task> list = new ArrayList<>();
		list.add(new Task(LocalDate.of(2021, 10, 21), "牛乳を買う", true));
		list.add(new Task(LocalDate.of(2021, 9, 15), "○○社面接", false));
		list.add(new Task(LocalDate.of(2021, 12, 4), "手帳を買う", true));
		list.add(new Task(LocalDate.of(2021, 8, 10), "散髪に行く", false));
		list.add(new Task(LocalDate.of(2021, 11, 9), "スクールの課題を解く", false));

		// 未完了のタスク数をカウントして表示
		// .filter：未完了タスクをフィルタリング
		// .count：終端処理でカウントを取得
		long backlogCount = list.stream().filter(task -> !task.isDone()).count();

		// 未完了のタスクだけをフィルタリングして表示
		System.out.println("\n未完了のタスクの個数は「" + backlogCount + "」");
		System.out.println("\n【未完了のタスクを昇順に並び替えて一覧表示】");
		
		// ラムダ式を使用して未完了タスクをフィルタリング
		// .filter：未完了タスクをフィルタリング
		// .sorted：日付で並び変える
		// TaskクラスのcompareToメソッドが使用される
		list.stream()
			.filter(task -> !task.isDone()) 
			.sorted() 
			.forEach(System.out::println);

	}

}
