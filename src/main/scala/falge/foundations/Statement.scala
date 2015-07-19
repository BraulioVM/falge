package falge.foundations

package object statement {
	type Statement[T] = (List[T], Set[T]) => Boolean
}
