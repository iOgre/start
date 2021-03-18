ZIO
ZIO[R,E,A] datatype has three type parameters
R - enviRonment type - If Any, means that effect has no reqs, bcs you can run eff with any value, eg Unit ()
E - failure type - Eff will fail with value of type E, if Nothing - means that effect cannot fail
A - success type - Eff will succeed with type A. If A is Unit, means that effect will produce no useful
information, while if it's Nothing, it means the effect will run forever (or until failed)

E.g, an effect of type ZIO[Any, IOException, Byte] has no reqs, may fail with value of type IOException,
or succeed with value of type Byte

A value of type ZIO[R,E,A] is effectful version of R => Either[E,A]

ZIO effects are not actually functions, bcs they model complex effects like asynchrous and concurrent effects

Pure functions
    Total - return an output for every input
    Deterministic - same ouput for same input
    Pure - only effect of providing a function
        an input is computing an the output

Functional programs do not interact with external worlds directly,
bcs that involves partiality, non-determinism and side-effects.
Instead, functional programs construct and return data structures,
which describe (or model) interaction with the real world.

Immutable data structures that modelt procedural effects are called functional effects.


