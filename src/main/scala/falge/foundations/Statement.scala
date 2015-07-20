package falge.foundations

package object statement {
	type Statement[T] = (List[T], Set[T]) => Boolean	// Statement about some elements in a set
}
