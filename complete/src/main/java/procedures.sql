#############################################
CREATE DEFINER=`root`@`localhost` PROCEDURE `login`(
	IN pi_user text,
    IN pi_pass text,
    IN pi_channel_id int,
    OUT po_code text,
    OUT	po_description text,
    OUT	po_token text
)
BEGIN
	DECLARE var_user_id int;
    DECLARE var_count int;
    DECLARE var_salt text;
    DECLARE var_md5 text;
	set @var_user_id = 0;
    set @var_count = 0;
	SELECT id INTO var_user_id
	FROM user where user_name = pi_user;

    if(var_user_id != 0) then
		SELECT salt into var_salt
        FROM user_password
        WHERE user_id = var_user_id and status = 1;

        SELECT MD5(CONCAT(var_salt, pi_pass)) INTO var_md5;

		SELECT count(*) INTO var_count
		FROM user_password
        where user_id = var_user_id and password = var_md5;
        if(var_count = 0) then
			set po_code = '400';
			set po_description = 'User or password is wrong';
			set po_token = '0';
        else
			SELECT SUBSTRING(MD5(RAND()) FROM 1 FOR 20) INTO po_token;
            update user_auth_token set status = 0 where user_id = var_user_id and channel_id = pi_channel_id;
            insert into user_auth_token (user_id, channel_id, token) values (var_user_id, pi_channel_id, po_token);
			set po_code = '000';
			set po_description = 'Success';
		end if;
    else
		set po_code = '400';
        set po_description = 'User or password is wrong';
        set po_token = '0';
	end if;
  END

#######################################################
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAgencyAll`(
	IN pi_offset int,
    IN pi_limit int,
    OUT po_total int,
    OUT po_code text,
    OUT po_description text
)
BEGIN
	set @po_code = '999';
    set @po_description = 'System error';
	SELECT count(*) INTO po_total
	FROM Agency;
    set po_code = '000';
    set po_description = 'Success';
    SELECT id, user_id, name, phone, address
    FROM agency;
  END


#########################################################
CREATE DEFINER=`root`@`localhost` PROCEDURE `verifySession`(
	IN pi_uid int,
    IN pi_channel_id int,
	IN pi_token text,
	OUT po_code text,
	OUT po_descripton text
)
BEGIN
	DECLARE var_time datetime;
    DECLARE var_id int;
    set @var_id = 0;
    SELECT id INTO var_id
		FROM  user_auth_token
        where uid = pi_uid and channel_id = pi_channel_id and token = pi_token and status = 1;
	if(var_id > 0) then
		#token ton tai
		SELECT updated_at INTO var_time
		FROM  user_auth_token
        where id = var_id;
        if(ADDTIME(var_time, 1800) > CURRENT_TIMESTAMP) then
			#token ok
            update user_auth_token set updated_at = CURRENT_TIMESTAMP where id = var_id;
            set po_code = '000';
            set po_descripton = 'Success';
		else
			set po_code = '039';
            set po_descripton = 'Session expired';
        end if;
    else
		#token khong ton tai
		set po_code = '038';
		set po_descripton = 'Session ivalid';
    end if;
END

################################################################
CREATE DEFINER=`root`@`localhost` PROCEDURE `logout`(
	IN pi_user text,
    IN pi_channel_id int,
    IN	po_token text,
    OUT po_code text,
    OUT	po_description text
)
BEGIN
	DECLARE var_uid int;
    DECLARE var_verify int;
	set @var_uid = 0;
    set @var_verify = 0;

	SELECT id INTO var_uid
		FROM user where user_name = pi_user;
	CALL verifySession(var_uid, pi_channel_id, po_token, po_code, po_description);
    if(po_code = '000') then
		update user_auth_token set status = 0 where uid = var_uid and channel_id = pi_channel_id;
		set po_code = '000';
        set po_description = 'Success';
	end if;
END