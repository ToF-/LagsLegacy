# TASKS

Our company, LAGS (Louez votre Avion et Gagnez des Sous), owns an airplane. Our customers are airline companies which rent our airplane to accomodate occasional overcapacity.

Mr. Robinson, the CEO of our company, uses a special program to predict the company's revenue by reading a list of customer orders. This program was written a long time ago. It used to work perfectly well until last week, when we discovered that the input file format has changed.

Unfortunately, the author of the original program is no longer with us, as he retired some 15 years ago. So Mr. Robinson asked his nephew David, who is currently an intern at the company, to see if he could change the program and make it work with the new order file format.

David told us that repairing the program was hopeless, as it was too badly designed, but he proposed to do a rewrite.

That's his program you have on the repository.

Where's David you ask? I think he's on vacation with his uncle. For all I know they are probably sailing somewhere between Ionan Sea and Corsica, not sure.

Do we have the original program? Ah there's a problem with that: David says he deleted it.

## Explain what the code does

While Mr. Robinson's nephew is away, have a look at the program and see if it can be documented. It's important after all. Having some tests would be good, too. David didn't really think about testing, but he sure will be pleased to see some tests running when he's back.

## Can you fix a bug?

The initial program (the one that was written 15 years ago and that we lost), given the typical `orders.csv` would output _15801153_, which is known to be the correct result for that set of orders.  The current program, given the same file, outputs _15801048_. It's not a big difference, but still.

Given another set of orders, like the one in the file `small.csv`, though, both programs output the same result, so there is hope.

## Please make the program run faster

Not sure if you will notice it, but David's program happens to be awfully slow. Several dozens of seconds to compute 30000 orders is unacceptable. The initial program was blazingly fast, but then again it was impossible to adapt it to the new format, so what do I know.

Should we expect larger sets of orders in the future ? I don't think so. The business is a bit on the decline, sadly. Thirty thousands orders is quite the maximum.

## We need a new feature

Mr. Robinson likes his program, but he would really enjoy being able to know not only the total revenue that can be predicted for a set of orders, but also which of them contribute to the revenue.  Mr. Robinson gave me an example where he used a small set of orders -- see `sample.csv`:

Given the orders:

- `FOO` from 0 to 10 at price 100,
- `BAR` from 3 to 12 at price 140,
- `QUX` from 10 to 15 at price 70,
- `BAZ` from 11 to 17 at price 80

not only the program should output `180` -- the correct revenue from such a set -- but also the orders to accept. Something like this:

- take order `FOO` for 100
- take order `BAZ` for 80
- total : 180
 
## Plan, Do, Check, Act

- Start with observing the program, from a "black box" perspective. There are files of different size in the `data` folder: try the program with these file.
- What are you hypotheses about the program? What does it do? How does it work? What problems do you notice?
- What could be the expectations about this program? From a business point of view? From a technical point of view? From a management point of view?
- What is the nature of the problem solved by the program? What would be a better way to solve it?
- What would be a metaphor for the way the current version of the code solves the problem? What would be a better metaphor? 
- What change should be made to the code?


