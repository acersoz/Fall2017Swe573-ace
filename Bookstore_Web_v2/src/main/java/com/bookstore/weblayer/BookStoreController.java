package com.bookstore.weblayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.datalayer.entity.Book;
import com.bookstore.datalayer.entity.User;
import com.bookstore.datalayer.entity.Tag;
import com.bookstore.servicelayer.BookService;
import com.bookstore.servicelayer.UserService;
import com.bookstore.servicelayer.TagService;
import com.bookstore.weblayer.model.AddBookTag;
import com.bookstore.weblayer.model.Registration;
import com.bookstore.weblayer.model.UserAuthentication;

@RestController
@RequestMapping("/bookstore/v1")
public class BookStoreController {

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	@Autowired
	private TagService tagService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers() {
		return userService.getUserList();
	}

	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public @ResponseBody List<String> getAllRoles() {
		return userService.getRoleNames();
	}

	@RequestMapping(value = "/user/{userid}", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable("userid") Integer userId) {
		return userService.findUser(userId);
	}

	@RequestMapping(value = "/user/{userid}", method = RequestMethod.DELETE)
	public @ResponseBody User deleteUser(@PathVariable("userid") Integer userId) {
		return userService.findUser(userId);
	}

	@RequestMapping(value = "/insert_user", method = RequestMethod.POST)
	public @ResponseBody Boolean insertUser(@RequestBody Registration user) {
		return userService.insertUser(user);
	}

	@RequestMapping(value = "/login/user", method = RequestMethod.POST)
	public @ResponseBody User loginUser(@RequestBody UserAuthentication userAuthentication) {
		return userService.login(userAuthentication);
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public @ResponseBody Boolean insertBook(@RequestBody Book book) {
		return bookService.save(book);
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	/*
	 * @RequestMapping(value="/book", method=RequestMethod.GET) public @ResponseBody
	 * Book getBook(@RequestParam("bookId") Integer bookId) { return
	 * bookService.findBook(bookId); }
	 */

	@RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
	public @ResponseBody Book getBook(@PathVariable("bookId") Integer bookId) {
		return bookService.findBook(bookId);
	}
	/*
	 * @RequestMapping(value="/tag", method=RequestMethod.POST) public @ResponseBody
	 * Boolean insertTag(@RequestBody Tag tag) { //return tagService.insertTag(tag);
	 * return true; }
	 */

	@RequestMapping(value = "/tag/{tagName}", method = RequestMethod.POST)
	public @ResponseBody Boolean insertTag(@PathVariable("tagName") String tagName) {
		return tagService.insertTag(tagName);
	}
	
	@RequestMapping(value = "/tagAdded/{tagName}", method = RequestMethod.POST)
	public @ResponseBody Boolean tagAdded(@PathVariable("tagName") String tagName) {
		return tagService.isTagAdded(tagName);
	}
	/*
	 * @RequestMapping(value="/tag/addBookTag", method=RequestMethod.POST)
	 * public @ResponseBody boolean loginUser(@RequestBody AddBookTag addBookTag) {
	 * return bookService.addBookTag(addBookTag); }
	 */

	@RequestMapping("/tag/addBookTag/{bookId}/{tagId}/{userId}")
	public @ResponseBody Boolean addBookTag(@PathVariable("bookId") Integer bookId,
			@PathVariable("tagId") Integer tagId, @PathVariable("userId") Integer userId) {
		return bookService.addBookTag(bookId, tagId, userId);
	}

	@RequestMapping(value = "/tags", method = RequestMethod.GET)
	public @ResponseBody List<Tag> getAllTags() {
		return tagService.getAllTags();
	}
}
