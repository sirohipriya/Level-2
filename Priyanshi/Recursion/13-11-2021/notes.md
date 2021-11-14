# Bit Manipulation

### To remove the last set bit of a number : N
----

We will be using AND(&) operator.

Steps:
- We will subtract 1 from our number.
- And then perform AND operation on both the numbers.
  > (N & (N - 1))
- Because all consecutive differ at the last set bits.


### To check if the bits are in alternate pattern : N = 101010
----

We use XOR(^) operator for this.

Steps: 
-  We use right shift(>>) operator on this number.
   > M = (N >> 1) =  010101
-  And we find the XOR of both these numbers.
   > (N ^ M) = 111111
-  If we get a number having set bits only then our orginal number had alternate bits.


### To check if the number has set bits only : N = 111
----
We will use AND(&) operator for this.

Steps:

- First we will be adding 1 to our given number.
  > If our number has sets bits only and we add one we will getting a number with only our MSB as set and all other bits will be reset.   
  > (N + 1) = 7(111) + 1(001) = 8(1000).
- Now, we perform AND operation on both these numbers. we will be getting 0 as our answer.
  > (N & (N + 1)) = 0
- Hence, we are getting zero then our orignal number has set bits only.


