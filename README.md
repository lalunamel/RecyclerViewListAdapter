# RecyclerView List Adapter for Kotlin

<a href="https://jitpack.io/#lalunamel/RecyclerViewListAdapter">
<img src="https://jitpack.io/v/lalunamel/RecyclerViewListAdapter.svg"/>
</a>

`RecyclerViewListAdapter` is a tiny Kotlin library that makes the creation of
a simple RecyclerView Adapter, its ViewHolders, and their Views as easy as possible.

## Usage

In order to create a `RecyclerViewListAdapter`, you need to supply a function
that creates a View or a View subclass, and another function that takes a View or View
subclass and an Item and updates that View.

### One line example

`val listAdapter = RecyclerViewListAdapter.create({ MyListItemView() }, {view, item -> view.update(item)})`

### Larger example

```kotlin
class MyListItemView(context: Context): LinearLayout(context) {

    val title: TextView

    init {
        title = TextView(context)
        addView(title)
    }

    fun update(title: String) {
        this.title.text = title
    }
}

class MyBiggerView(context: Context): LinearLayout(context) {
    val listAdapter: RecyclerViewListAdapter<MyListItemView, String>
    
    init {
        val createView = fun(): MyListItemView {
            return MyListItemView()
        }
        
        val updateView = fun(view: MyListItemView, item: String) {
            view.update(item)
        }
        
        listAdapter = RecyclerViewListAdapter.create(createView, updateView)
        val recyclerView = RecyclerView(context)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = listAdapter
        addView(recyclerView)
    }
}
```

## Binaries

This library is hosted on [JitPack.io](https://jitpack.io/#lalunamel/RecyclerViewListAdapter).
For the latest version number, see [GitHub Releases](https://github.com/lalunamel/RecyclerViewListAdapter/releases) 

**Step 1** Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
**Step 2** Add the dependency
```groovy
dependencies {
    compile 'com.github.lalunamel:RecyclerViewListAdapter:VERSION'
}
```

## Todo
- Does this work with multiple versions of recyclerview?
- Does this work with Java?
- How does this work with regular xml views (non programmatic)?