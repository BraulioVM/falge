# Falge
![Travis Build](https://travis-ci.org/BraulioVM/falge.svg)
> Finite algebra experiments with scala

Let's say you want to see whether Z[2] is a semigroup:

````scala
import falge.structures.semigroup

val potential_semigroup = new Semigroup[Int](Set(0, 1), (x, y) => (x + y) % 2)

assert(potential_semigroup.verify(), true)
````

### Structures
I have already implemented and written tests for the following algebraic structures
* [Magmas](https://en.wikipedia.org/wiki/Magma_(algebra))
* [Semigroups](https://en.wikipedia.org/wiki/Semigroup)
