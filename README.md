# Sorting Algorithms in Java

Implementations of classic sorting algorithms on both **arrays** and **singly linked lists**, with a step-by-step, colour-coded terminal visualisation of every comparison and swap.

> Built as a college assignment for an Object-Oriented Programming in Java module.

## Algorithms

| Algorithm      | Array | Linked list |
|----------------|:-----:|:-----------:|
| Bubble Sort    | ✅    | ✅          |
| Selection Sort | ✅    | ✅          |
| Insertion Sort | ✅    |             |
| Shell Sort     | ✅    |             |
| Quick Sort     | ✅    |             |
| Heap Sort      | ✅    |             |
| Merge Sort     |       | ✅          |

Linked-list versions rearrange the nodes themselves (pointer manipulation) rather than copying values.

## How it works

- `SortingAlgorithm<T>` is a generic interface that every algorithm implements.
- `Array` wraps an `int[]` filled with a seeded shuffle of `0..n-1`. All access goes through `compare(i, j)` and `swap(i, j)`, which count operations and print the array with the affected elements highlighted.
- `LinkedList` / `ListNode` provide a minimal singly linked list, printed before and after sorting.
- At the end of the array run, each algorithm gets a cost score (`2 × compares + 4 × swaps`) so they can be compared on the same input.

## Example output (n = 10, seed = 42)

```
BubbleSort: 190
HeapSort: 180
InsertionSort: 162
QuickSort: 88
SelectionSort: 190
ShellSort: 114
```

## Running it

Requires **Java 21+**.

```bash
cd src
javac *.java

java Array        # array sorts, with compare/swap trace and cost summary
java LinkedList   # linked-list sorts, before/after
```

The array size and random seed can be changed via `n` and `seed` in each class's `main` method.

> The trace uses ANSI colour codes, so run it in a terminal that supports them (most do; older Windows `cmd` may not).

## Project structure

```
src/
├── SortingAlgorithm.java   # generic interface
├── Array.java              # instrumented array + array benchmark (main)
├── LinkedList.java         # linked list + list benchmark (main)
├── ListNode.java
├── BubbleSort.java
├── SelectionSort.java
├── InsertionSort.java
├── ShellSort.java
├── QuickSort.java
├── HeapSort.java
└── MergeSort.java
```
