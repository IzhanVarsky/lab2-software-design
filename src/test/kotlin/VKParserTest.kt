import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Assert
import org.junit.Test

class VKParserTest {
    private val testResponse =
        """{"response":{"items":[{"id":75,"date":1633992594,"owner_id":672201691,"from_id":672201691,"post_type":"post","text":"\"I wish I was a neutron bomb, for once I could go off\nI wish I was a sacrifice but somehow still lived on\nI wish I was a sentimental ornament you hung on\nThe Christmas tree, I wish I was the star that went on top\nI wish I was the evidence, I wish I was the grounds\nFor 50 million hands upraised and open toward the sky\n\nI wish I was a sailor with someone who waited for me\nI wish I was as fortunate, as fortunate as me\nI wish I was a messenger and all the news was good\nI wish I was the full moon shining off a Camaro's hood\n\nI wish I was an alien at home behind the sun\nI wish I was the souvenir you kept your house key on\nI wish I was the pedal brake that you depended on\nI wish I was the verb 'to trust' and never let you down\n\nI wish I was a radio song, the one that you turned up\nI wish\nI wish...\"\n\n#Grunge #Nirvana\n\n#Red #TaylorSwift\n\n#KanyeWest #USA \n#Road #GoodNight \n\n#VK #Cats","attachments":[{"type":"video","video":{"access_key":"f0ed680e3cbbb60250","can_comment":0,"can_like":1,"can_repost":1,"can_subscribe":1,"can_add_to_faves":1,"can_add":1,"comments":0,"date":1633992593,"description":"\"Wishlist\" by Pearl Jam\nListen to Pearl Jam: https:\/\/PearlJam.lnk.to\/listenYD\nSubscribe to the official Pearl Jam YouTube channel: https:\/\/PearlJam.lnk.to\/subscribe_YD\n\nWatch more Pearl Jam videos: https:\/\/PearlJam.lnk.to\/listenYC\/youtube\n\nFollow Pearl Jam:\nFacebook: https:\/\/PearlJam.lnk.to\/followFI\nInstagram: https:\/\/PearlJam.lnk.to\/followII\nTwitter: https:\/\/PearlJam.lnk.to\/followTI\nWebsite: https:\/\/PearlJam.lnk.to\/followWI\nSpotify: https:\/\/PearlJam.lnk.to\/followSI\nYouTube: https:\/\/PearlJam.lnk.to\/subscribe_YD","duration":209,"image":[{"height":96,"url":"https:\/\/sun9-40.userapi.com\/SnFDOPO5cm7sRSxXHaLvcL8WSlMUG-HdQd88Vg\/U6J7GGFh0gA.jpg","width":130,"with_padding":1},{"height":120,"url":"https:\/\/sun9-6.userapi.com\/HOtOIeFr30OJQAdUxpvCnmiSpXRAVV5taZu5kA\/EJn07vqkkd0.jpg","width":160,"with_padding":1},{"height":240,"url":"https:\/\/sun9-52.userapi.com\/lj27-6Si50YuLeoL6PUggGSurm1AXVaU8JtivQ\/yD0TWWdxmok.jpg","width":320,"with_padding":1},{"height":450,"url":"https:\/\/sun9-15.userapi.com\/d3IULEueVuis5hCZRRolohFZkL3v8C0wQcGuDQ\/mhsoP_u9dyo.jpg","width":800,"with_padding":1}],"id":456239150,"owner_id":672201691,"title":"Pearl Jam - Wishlist (Official Audio)","track_code":"video_d87014e6_ME2ew-YxvXgyq4C2rYYGUckCLo2P0k0rdo6c8yUaW3J4DJ8DJzP9YnEql3ugy4rdB05jwY4PFrG","type":"video","views":1,"local_views":0,"platform":"YouTube"}},{"type":"audio","audio":{"artist":"Pearl Jam","id":456243871,"owner_id":2000476836,"title":"Wishlist","duration":25,"is_explicit":false,"is_focus_track":false,"track_code":"6f9f46a9Z6VruBjrpeTVoPOQWdRlVCna4_eLFUBxoPtZeUP5ty5prgrMbIo","url":"https:\/\/vk.com\/mp3\/audio_api_unavailable.mp3","date":1633992637,"main_artists":[{"name":"Pearl Jam","domain":"4745808276805231479","id":"4745808276805231479"}],"short_videos_allowed":false,"stories_allowed":false,"stories_cover_allowed":false}}],"post_source":{"type":"vk"},"comments":{"can_post":0,"count":0,"groups_can_post":true},"likes":{"can_like":1,"count":0,"user_likes":0,"can_publish":1},"reposts":{"count":1,"user_reposted":0},"views":{"count":2},"donut":{"is_donut":false},"short_text_rate":0.800000,"carousel_offset":0},{"id":53,"date":1633990812,"owner_id":669048733,"from_id":669048733,"post_type":"post","text":"С днём рождения, ВКонтакте! \nКакое у вас здесь любимое занятие? \nМоё — вот это:\n[club27902394|Приложение ВКонтакте]\n#vk","attachments":[{"type":"photo","photo":{"album_id":-7,"date":1633990812,"id":457239261,"owner_id":669048733,"has_tags":false,"access_key":"c130091939096fa269","sizes":[{"height":130,"url":"https:\/\/sun9-16.userapi.com\/impg\/mDRduApSDn5EMJrYeps2OgDkT823aKq1EskG3A\/y8DTxbLK524.jpg?size=130x130&quality=96&sign=6ed74ca3b1f59b6b67aa3b8bd7ee4d1a&c_uniq_tag=Ho1sAC0FsZRM4pq7ehVwI7K5uhSpGWZYXU1yc8eHJTs&type=album","type":"m","width":130},{"height":130,"url":"https:\/\/sun9-16.userapi.com\/impg\/mDRduApSDn5EMJrYeps2OgDkT823aKq1EskG3A\/y8DTxbLK524.jpg?size=130x130&quality=96&sign=6ed74ca3b1f59b6b67aa3b8bd7ee4d1a&c_uniq_tag=Ho1sAC0FsZRM4pq7ehVwI7K5uhSpGWZYXU1yc8eHJTs&type=album","type":"o","width":130},{"height":200,"url":"https:\/\/sun9-16.userapi.com\/impg\/mDRduApSDn5EMJrYeps2OgDkT823aKq1EskG3A\/y8DTxbLK524.jpg?size=200x200&quality=96&sign=532ca87104199eee859af3b79a149ace&c_uniq_tag=wdCnEhTFiQB5dbBznGBGmr5eQqS1mJFNLDVgp6KrMsE&type=album","type":"p","width":200},{"height":320,"url":"https:\/\/sun9-16.userapi.com\/impg\/mDRduApSDn5EMJrYeps2OgDkT823aKq1EskG3A\/y8DTxbLK524.jpg?size=320x320&quality=96&sign=04fb83d328e10fbe667c606723ca3eb7&c_uniq_tag=V2CJbH37CWL2plxRzPBx_I3JY6Wb8h1hH4xgXpckZDc&type=album","type":"q","width":320},{"height":510,"url":"https:\/\/sun9-16.userapi.com\/impg\/mDRduApSDn5EMJrYeps2OgDkT823aKq1EskG3A\/y8DTxbLK524.jpg?size=510x510&quality=96&sign=b01f46791ff8a81790be783bf883b18d&c_uniq_tag=vkG-LNj_9KzgrtABNZBRw3GiJBIbo7VBZHMQRVs3Uzs&type=album","type":"r","width":510},{"height":75,"url":"https:\/\/sun9-16.userapi.com\/impg\/mDRduApSDn5EMJrYeps2OgDkT823aKq1EskG3A\/y8DTxbLK524.jpg?size=75x75&quality=96&sign=f9c74b2e9aad260f80b7a4742b473b6a&c_uniq_tag=cu-44w7qhB9g3Bz9amiqAKUa3lwcjfBJPwmF-pihDdc&type=album","type":"s","width":75},{"height":1500,"url":"https:\/\/sun9-16.userapi.com\/impg\/mDRduApSDn5EMJrYeps2OgDkT823aKq1EskG3A\/y8DTxbLK524.jpg?size=1500x1500&quality=96&sign=7187ce28f7b3dcf84db206d5c88c09b7&c_uniq_tag=SkNx5h2giNs-kazlPUr5Fcgbpz_qG6VMDn_JODtQfXk&type=album","type":"w","width":1500},{"height":604,"url":"https:\/\/sun9-16.userapi.com\/impg\/mDRduApSDn5EMJrYeps2OgDkT823aKq1EskG3A\/y8DTxbLK524.jpg?size=604x604&quality=96&sign=0e5916912a175191055ac8240ee6fc2e&c_uniq_tag=3HZNWE6ksJw6Qh7mr2ZtyRNo1XA12yLbLG8Vgow6SSI&type=album","type":"x","width":604},{"height":807,"url":"https:\/\/sun9-16.userapi.com\/impg\/mDRduApSDn5EMJrYeps2OgDkT823aKq1EskG3A\/y8DTxbLK524.jpg?size=807x807&quality=96&sign=fd392f931d4afba80f9243b5e5823eae&c_uniq_tag=L8Dpvf6WQI2ATtOV-KIMArFYWHCK7NtmPa37VT5AbXs&type=album","type":"y","width":807},{"height":1080,"url":"https:\/\/sun9-16.userapi.com\/impg\/mDRduApSDn5EMJrYeps2OgDkT823aKq1EskG3A\/y8DTxbLK524.jpg?size=1280x1280&quality=96&sign=da046a85fa5924809720ca1dd05b974d&c_uniq_tag=eoc4IzhNGfX9gAgbE_aahKxlxuQzrwlMmXNLelaflug&type=album","type":"z","width":1080}],"text":""}},{"type":"doc","doc":{"id":616964548,"owner_id":669048733,"title":"y8DTxbLK524.jpg","size":416781,"ext":"jpg","date":1633990839,"type":4,"url":"https:\/\/vk.com\/doc669048733_616964548?hash=3c76f225cd213aa875&dl=GA:1633995804:1bb749db85957777c8&api=1&no_preview=1","preview":{"photo":{"sizes":[{"src":"https:\/\/sun9-68.userapi.com\/c532036\/u669048733\/d37\/-3\/m_54e2a9c4c3.jpg","width":130,"height":100,"type":"m"},{"src":"https:\/\/sun9-29.userapi.com\/c532036\/u669048733\/d37\/-3\/s_54e2a9c4c3.jpg","width":100,"height":75,"type":"s"},{"src":"https:\/\/sun9-19.userapi.com\/c532036\/u669048733\/d37\/-3\/x_54e2a9c4c3.jpg","width":604,"height":604,"type":"x"},{"src":"https:\/\/sun9-23.userapi.com\/c532036\/u669048733\/d37\/-3\/y_54e2a9c4c3.jpg","width":807,"height":807,"type":"y"},{"src":"https:\/\/sun9-34.userapi.com\/c532036\/u669048733\/d37\/-3\/z_54e2a9c4c3.jpg","width":1280,"height":1280,"type":"z"},{"src":"https:\/\/sun9-53.userapi.com\/c532036\/u669048733\/d37\/-3\/o_54e2a9c4c3.jpg","width":1500,"height":1500,"type":"o"},{"src":"https:\/\/sun9-53.userapi.com\/impf\/c532036\/u669048733\/d37\/-3\/o_54e2a9c4c3.jpg?size=288x288&quality=90&sign=4c48675a21ffd54bf60bbc5b39493d89&c_uniq_tag=3o5v-kcQ_Qy96RWXxVFdwdiQ5OS88qS-Fms_lwh--Xw","width":288,"height":288,"type":"i"},{"src":"https:\/\/sun9-53.userapi.com\/impf\/c532036\/u669048733\/d37\/-3\/o_54e2a9c4c3.jpg?size=192x192&quality=90&sign=2f6ef78e3cceaff14857f65054f45b85&c_uniq_tag=xYWipCrrZ5myhWZZppM3Ib2upCNXAcf9WZgGSgfn3LY","width":192,"height":192,"type":"d"}]}},"access_key":"9e7ca2a51e54175b3a"}},{"type":"audio","audio":{"artist":"INSTASAMKA","id":456243855,"owner_id":2000494630,"title":"Money Day","duration":25,"is_explicit":true,"is_focus_track":false,"track_code":"8eb22ba2REgyTY6z0yumF3p7vaXvQPJAy3GmQmOJ1TN3SvNCHv9KQ1M5-tI","url":"https:\/\/vk.com\/mp3\/audio_api_unavailable.mp3","date":1633990812,"main_artists":[{"name":"INSTASAMKA","domain":"7944855581176126718","id":"7944855581176126718"}],"subtitle":"prod. realmoneyken","short_videos_allowed":true,"stories_allowed":true,"stories_cover_allowed":false}},{"type":"situational_theme","situational_theme":{"id":21361,"owner_id":-22822305,"link":"https:\/\/vk.com\/app7644481#21361","date":1633702440,"title":"15 лет ВКонтакте","description":"Мемы, музыка, сохранёнки! Расскажите, что любите, в день рождения ВКонтакте.","category":"holidays","date_start":1633748400,"cover_photo":{"album_id":-7,"date":1633702438,"id":457280870,"owner_id":-199581556,"has_tags":false,"sizes":[{"height":73,"url":"https:\/\/sun9-77.userapi.com\/impg\/QuX9A6EoH0Z9R4NInY8RtLuDw7CvjJj7a0Fl8g\/cyXaTKUFFvs.jpg?size=130x73&quality=96&sign=61054cd814d73e07c67d3494150476c5&c_uniq_tag=Z_w57q4sTEGVgVMlLC9MMQ_4DXCTgYzGFRzxFX5V_-s&type=album","type":"m","width":130},{"height":87,"url":"https:\/\/sun9-77.userapi.com\/impg\/QuX9A6EoH0Z9R4NInY8RtLuDw7CvjJj7a0Fl8g\/cyXaTKUFFvs.jpg?size=130x87&quality=96&crop=89,0,941,630&sign=2ad490404100cc9a0b123c929b0f8b2b&c_uniq_tag=k6xW98EQMVeNosvjojD2TQSw7H7BuLRRdyWMeG3spr8&type=album","type":"o","width":130},{"height":133,"url":"https:\/\/sun9-77.userapi.com\/impg\/QuX9A6EoH0Z9R4NInY8RtLuDw7CvjJj7a0Fl8g\/cyXaTKUFFvs.jpg?size=200x133&quality=96&crop=86,0,947,630&sign=6c9b45f0fb8a37be9f3621e08dddffc6&c_uniq_tag=yB_ZE-zERfkfdIP4S8N3sC1P-1DAYjksR3biMKOCJBI&type=album","type":"p","width":200},{"height":213,"url":"https:\/\/sun9-77.userapi.com\/impg\/QuX9A6EoH0Z9R4NInY8RtLuDw7CvjJj7a0Fl8g\/cyXaTKUFFvs.jpg?size=320x213&quality=96&crop=87,0,946,630&sign=c458599d0f7b6737a578d1044b6eae8d&c_uniq_tag=i2W3ftlcTVYTv1Jynp4tNpggqSxZCrLNN1BtUUq15_A&type=album","type":"q","width":320},{"height":340,"url":"https:\/\/sun9-77.userapi.com\/impg\/QuX9A6EoH0Z9R4NInY8RtLuDw7CvjJj7a0Fl8g\/cyXaTKUFFvs.jpg?size=510x340&quality=96&crop=87,0,945,630&sign=7c27290f4b571fa2da7f0ea1b27a00b6&c_uniq_tag=44fSEybRTv5sm6oHB1_hgxsEzUeRovywiO6wI3EHUIA&type=album","type":"r","width":510},{"height":42,"url":"https:\/\/sun9-77.userapi.com\/impg\/QuX9A6EoH0Z9R4NInY8RtLuDw7CvjJj7a0Fl8g\/cyXaTKUFFvs.jpg?size=75x42&quality=96&sign=8dceede6e8bbb798af05a776659c0725&c_uniq_tag=-TD9LUcYmxfICeUEGzlKY1Hz7p75XeAuldn0ociMpKA&type=album","type":"s","width":75},{"height":340,"url":"https:\/\/sun9-77.userapi.com\/impg\/QuX9A6EoH0Z9R4NInY8RtLuDw7CvjJj7a0Fl8g\/cyXaTKUFFvs.jpg?size=604x340&quality=96&sign=fa62900541d1732c2117a8aea55a9099&c_uniq_tag=SJz3j4zplShbzUg7cQR4K7RLBheRrBqHgS_z9V76N8w&type=album","type":"x","width":604},{"height":454,"url":"https:\/\/sun9-77.userapi.com\/impg\/QuX9A6EoH0Z9R4NInY8RtLuDw7CvjJj7a0Fl8g\/cyXaTKUFFvs.jpg?size=807x454&quality=96&sign=2664d303644013ac2503a35f0937468a&c_uniq_tag=_CPMzx-hpGISlb6zxZwnckxwp69Rd-1YZlmkYd-dXZM&type=album","type":"y","width":807},{"height":630,"url":"https:\/\/sun9-77.userapi.com\/impg\/QuX9A6EoH0Z9R4NInY8RtLuDw7CvjJj7a0Fl8g\/cyXaTKUFFvs.jpg?size=1120x630&quality=96&sign=316e4862d55a0994ba830ac78c1e6218&c_uniq_tag=I5Wgkydx7vnujFtURQsJjveBYHMZau1haMRYaMbcfOY&type=album","type":"z","width":1120}],"text":"","user_id":100},"squared_cover_photo":{"album_id":-7,"date":1633702438,"id":457280234,"owner_id":-200757200,"has_tags":false,"sizes":[{"height":130,"url":"https:\/\/sun9-81.userapi.com\/impg\/f0LElRIrdsnbOme_iNiyTxdY7mOFYty4O6SEzA\/Ik6_I9MPhWo.jpg?size=130x130&quality=96&sign=ca315a1126f878fe8d1a5e3f0126c278&c_uniq_tag=5fLXek5Ij5KHJhiEuO16VmhHDr7OO1p6gsgSpYlXcLM&type=album","type":"m","width":130},{"height":130,"url":"https:\/\/sun9-81.userapi.com\/impg\/f0LElRIrdsnbOme_iNiyTxdY7mOFYty4O6SEzA\/Ik6_I9MPhWo.jpg?size=130x130&quality=96&sign=ca315a1126f878fe8d1a5e3f0126c278&c_uniq_tag=5fLXek5Ij5KHJhiEuO16VmhHDr7OO1p6gsgSpYlXcLM&type=album","type":"o","width":130},{"height":200,"url":"https:\/\/sun9-81.userapi.com\/impg\/f0LElRIrdsnbOme_iNiyTxdY7mOFYty4O6SEzA\/Ik6_I9MPhWo.jpg?size=200x200&quality=96&sign=ada75424aa93b1767a66b50b0c6fa9cb&c_uniq_tag=sMVDYRnkb5GMQnktxreoEmOSsnV0aKsU5QmBpQCvidA&type=album","type":"p","width":200},{"height":320,"url":"https:\/\/sun9-81.userapi.com\/impg\/f0LElRIrdsnbOme_iNiyTxdY7mOFYty4O6SEzA\/Ik6_I9MPhWo.jpg?size=320x320&quality=96&sign=6a394f4ed8e27ea40c1ad38f28b3e84d&c_uniq_tag=ygKR_PPBl5tpZaq30Goh8-KsiE2d8mNqVSKVbcfiYVo&type=album","type":"q","width":320},{"height":510,"url":"https:\/\/sun9-81.userapi.com\/impg\/f0LElRIrdsnbOme_iNiyTxdY7mOFYty4O6SEzA\/Ik6_I9MPhWo.jpg?size=510x510&quality=96&sign=ae1e1c0fc74a16a414ba0b35155ed844&c_uniq_tag=Z0NbFAwOM7jOny7utHDhwoXXshgdIumVSkwZpDHK0k0&type=album","type":"r","width":510},{"height":75,"url":"https:\/\/sun9-81.userapi.com\/impg\/f0LElRIrdsnbOme_iNiyTxdY7mOFYty4O6SEzA\/Ik6_I9MPhWo.jpg?size=75x75&quality=96&sign=b9ea77203d663f4083b8cb7900eb21a1&c_uniq_tag=He3jGp7KvDE0jYmCksAXlfn6A97LryF7vgZ7j8ivlR4&type=album","type":"s","width":75},{"height":604,"url":"https:\/\/sun9-81.userapi.com\/impg\/f0LElRIrdsnbOme_iNiyTxdY7mOFYty4O6SEzA\/Ik6_I9MPhWo.jpg?size=604x604&quality=96&sign=9fa81cf0bfc012867d3c29aea41af8a9&c_uniq_tag=VGnyHB3ZgbcqduhDavGbPJmkLhXuk_Q378fufDXWefY&type=album","type":"x","width":604},{"height":630,"url":"https:\/\/sun9-81.userapi.com\/impg\/f0LElRIrdsnbOme_iNiyTxdY7mOFYty4O6SEzA\/Ik6_I9MPhWo.jpg?size=630x630&quality=96&sign=141e225b400955d1b6fd6df90539e4e9&c_uniq_tag=ZxHlZpS-h8OT9sxzxkSfOLBsBIRVgAo-354j0nRSJso&type=album","type":"y","width":630}],"text":"","user_id":100},"is_anonymous":false,"publications_count":67378,"views_count":564153,"friends_posted_count":0,"friends_posted":[],"can_edit":false,"can_delete":false}}],"post_source":{"platform":"android","type":"api"},"comments":{"can_post":1,"count":0,"groups_can_post":true},"likes":{"can_like":1,"count":0,"user_likes":0,"can_publish":1},"reposts":{"count":0,"user_reposted":0},"views":{"count":3},"donut":{"is_donut":false},"short_text_rate":0.800000,"carousel_offset":0},{"id":1,"date":1633988647,"owner_id":680107314,"from_id":680107314,"post_type":"post","text":"RESIDENT EVIL 8 VILLAGE - Walkthrough Gameplay - Part 1 - No Commentary\n\nhttps:\/\/www.youtube.com\/watch?v=gawmUZSUG0c&ab_channel=VLECHGaming\n\n#residentevil #residentevilvillage #vk #gameplay #walkthrough","attachments":[{"type":"video","video":{"access_key":"26b5b7f50f26e4d345","can_comment":0,"can_like":0,"can_repost":0,"can_subscribe":0,"can_add_to_faves":0,"can_add":0,"date":1633988587,"description":"#residentevil #village #walkthrough #gameplay #nocommentary\n\nABOUT THIS GAME:\n\nSet a few years after the horrifying events in the critically acclaimed Resident Evil 7 biohazard, the all-new storyline begins with Ethan Winters and his wife Mia living peacefully in a new location, free from their past nightmares. Just as they are building their new life together, tragedy befalls them once again.\n\nOYUN HAKKINDA: \n\nResident Evil 7 biohazard'daki korkunç olaylardan birkaç yıl sonra geçen yepyeni hikaye örgüsü, geçmişteki kabuslarından kurtularak yeni bir yerde huzurlu bir hayat sürdüren Ethan Winters ve eşi Mia ile başlıyor. Birlikte yeni bir hayata başlamak üzereyken bir kez daha üzerlerine bir trajedi çöker.","duration":3786,"image":[{"height":96,"url":"https:\/\/sun9-83.userapi.com\/HsaY4MOT1KrcmzESV8CjIXohpK3Uo38lFIvmEQ\/GQuRMEWUVCc.jpg","width":130,"with_padding":1},{"height":120,"url":"https:\/\/sun9-47.userapi.com\/qj3NCXvnWJGAHo81KrCQHyNU00W5EFVk1w8A1g\/qQRttdv0Ifg.jpg","width":160,"with_padding":1},{"height":240,"url":"https:\/\/sun9-6.userapi.com\/7aIQPg98NELYCNRkmMA-JC4_6deP4gVIJ_ugmQ\/oZNv58cE354.jpg","width":320,"with_padding":1},{"height":450,"url":"https:\/\/sun9-79.userapi.com\/aUVm7zPKOgTniNYyIQCfjlqjrHyrBDavs1wbfg\/kEPtCMSUenw.jpg","width":800,"with_padding":1}],"id":456239017,"owner_id":680107314,"title":"RESIDENT EVIL 8 VILLAGE - Walkthrough Gameplay - Part 1 - No Commentary","track_code":"video_a6687d4cZl6QYWootEuNal_PxstuEJKWfkEQCI2aRkrTOVwaZl1cfZdpbSq1SOFqa5Dy_lgioa9OcCcP-PQ","type":"video","views":1,"platform":"YouTube"}}],"post_source":{"type":"vk"},"comments":{"can_post":1,"count":0,"groups_can_post":true},"likes":{"can_like":1,"count":0,"user_likes":0,"can_publish":1},"reposts":{"count":0,"user_reposted":0},"views":{"count":5},"donut":{"is_donut":false},"short_text_rate":0.800000}],"next_from":"3\/680107314_1","count":1000,"total_count":676330}}
"""

    @Test
    fun parseResponse() {
        val parser = VKTreeParser()
        val info = parser.parseTree(ObjectMapper().readTree(testResponse))
        Assert.assertEquals(info, listOf<Long>(1633992594, 1633990812, 1633988647))
    }
}